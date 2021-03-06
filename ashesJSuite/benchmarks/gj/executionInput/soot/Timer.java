/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

/* Reference Version: $SootVersion: 1.beta.5.dev.74 $ */




package soot;

import soot.util.*;
import java.util.*;

public class Timer
{
    private long duration;
    private long startTime;
    private boolean hasStarted;

    private String name;

    private static List outstandingTimers = new ArrayList();
    private static boolean isGarbageCollecting;
    
    public static Timer forcedGarbageCollectionTimer = new Timer("gc");
    private static boolean isSubtractingGC;
    
    private static int count;
    
    public Timer(String name)
    {
        this.name = name;
        duration = 0;
    }
    
    public Timer()
    {
        this("unnamed");
    }
    
    public static void setSubtractingGC(boolean value)
    {
        isSubtractingGC = value;
    }
    
    public void start()
    {
        // Substract garbage collection time
            if(!isGarbageCollecting && isSubtractingGC && ((count++ % 4) == 0))
            {
                // garbage collects only every 4 calls to avoid round off errors
                
                isGarbageCollecting = true;
            
                forcedGarbageCollectionTimer.start();
                
                // Stop all outstanding timers
                {
                    Iterator timerIt = outstandingTimers.iterator();
                    
                    while(timerIt.hasNext())
                    {
                        Timer t = (Timer) timerIt.next();
                        
                        t.end();
                    }
                }
                
                System.gc();
        
                // Start all outstanding timers
                {
                    Iterator timerIt = outstandingTimers.iterator();
                    
                    while(timerIt.hasNext())
                    {
                        Timer t = (Timer) timerIt.next();
                        
                        t.start();
                    }
                }
                
                forcedGarbageCollectionTimer.end();
                
                isGarbageCollecting = false;
            }
                        
        
        startTime = System.currentTimeMillis();
        
        if(hasStarted)
            throw new RuntimeException("timer " + name + " has already been started!");
        else
            hasStarted = true;
        
        
        if(!isGarbageCollecting) 
        {
            outstandingTimers.add(this);
        }
            
    }

    public String toString()
    {
        return name;
    }
    
    public void end()
    {   
        if(!hasStarted)
            throw new RuntimeException("timer " + name + " has not been started!");
        else
            hasStarted = false;
        
        duration += System.currentTimeMillis() - startTime;
        
        
        if(!isGarbageCollecting)
        {
            outstandingTimers.remove(this);
        }
    }

    public long getTime()
    {
        return duration;
    }
}




