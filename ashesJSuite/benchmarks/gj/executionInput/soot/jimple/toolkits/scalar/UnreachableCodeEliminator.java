/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Phong Co
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


package soot.jimple.toolkits.scalar;

import soot.util.*;
import soot.*;
import soot.jimple.*;
import java.io.*;
import java.util.*;
import soot.toolkits.graph.*;

public class UnreachableCodeEliminator extends BodyTransformer
{
    private static UnreachableCodeEliminator instance = new UnreachableCodeEliminator();
    private UnreachableCodeEliminator() {}

    public static UnreachableCodeEliminator v() { return instance; }

    static boolean debug = soot.Main.isInDebugMode;

    static CompleteUnitGraph stmtGraph;
    static HashSet visited;
    static int numPruned;

    protected void internalTransform(Body b, String phaseName, Map options) 
    {
        StmtBody body = (StmtBody)b;
        
        if (soot.Main.isVerbose) 
            System.out.println("[" + body.getMethod().getName() + "] Eliminating unreachable code...");

        numPruned = 0;
        stmtGraph = new CompleteUnitGraph(body);
        visited = new HashSet();
            
        // mark first statement and all its successors, recursively
        if (!body.getUnits().isEmpty())
            visitStmt((Stmt)body.getUnits().getFirst());

        
        Iterator stmtIt = body.getUnits().snapshotIterator();
        while (stmtIt.hasNext()) 
        {
            // find unmarked nodes
            Stmt stmt = (Stmt)stmtIt.next();
            
            if (!visited.contains(stmt)) 
            {
                body.getUnits().remove(stmt);
                numPruned++;
            }
        }
        if (soot.Main.isVerbose)
            System.out.println("[" + body.getMethod().getName() + "]     Removed " + numPruned + " statements...");
            
        // Now eliminate empty traps.
        {
            Iterator trapIt = b.getTraps().iterator();
            
            while(trapIt.hasNext())
            {
                Trap t = (Trap) trapIt.next();
                
                if(t.getBeginUnit() == t.getEndUnit())
                    trapIt.remove();
            }
        }
        
  } // pruneUnreachables

    private static void visitStmt(Stmt stmt) {
        //ignore if already seen
        if (visited.contains(stmt)) {
            return;
        }

        // add to list of visited nodes
        visited.add(stmt);

        // visit all successors recursively
        Iterator succIt = stmtGraph.getSuccsOf(stmt).iterator();

        while (succIt.hasNext())
            visitStmt((Stmt)succIt.next());
    } // visitStmt
} // UnreachablePruner
    




