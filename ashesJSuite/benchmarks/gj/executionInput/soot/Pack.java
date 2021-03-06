/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Raja Vallee-Rai and Patrick Lam
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

/** A wrapper object for a pack of optimizations.
 * Provides chain-like operations, except that the key is the phase name. */
public class Pack
{
    Chain opts = new HashChain();
    
    public Iterator iterator() { return opts.iterator(); }

    public void add(Transform t) { opts.add(t); }

    public void insertAfter(Transform t, String phaseName) 
    {
        Iterator it = opts.iterator();
        while (it.hasNext())
        {
            Transform tr = (Transform)it.next();
            if (tr.getPhaseName().equals(phaseName))
            {
                opts.insertAfter(t, tr);
                return;
            }
        }
        throw new RuntimeException("phase "+phaseName+" not found!");
    }

    public void insertBefore(Transform t, String phaseName)
    {
        Iterator it = opts.iterator();
        while (it.hasNext())
        {
            Transform tr = (Transform)it.next();
            if (tr.getPhaseName().equals(phaseName))
            {
                opts.insertBefore(t, tr);
                return;
            }
        }
        throw new RuntimeException("phase "+phaseName+" not found!");
    }

    public void apply()
    {
        Iterator it = iterator();
        while (it.hasNext())
        {
            Transform t = (Transform)it.next();
            ((SceneTransformer)(t.getTransformer())).transform
                (t.getPhaseName(), t.getOptions());
        }
    }

    public void apply(Body b)
    {
        Iterator it = iterator();
        while (it.hasNext())
        {
            Transform t = (Transform)it.next();
            ((BodyTransformer)(t.getTransformer())).transform
                (b, t.getPhaseName(), t.getOptions());
        }
    }
}
