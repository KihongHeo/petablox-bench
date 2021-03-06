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

import java.io.*;
import java.util.*;

import soot.coffi.*;

/** This is somewhat of a hack; it provides a Soot interface to Coffi. */
public class ClassFileBody extends Body
{
    public soot.coffi.ClassFile coffiClass;
    public soot.coffi.method_info coffiMethod;

    public ClassFileBody(SootMethod method)
    {
        super(method);
        
        if(!method.isConcrete())

            throw new NullPointerException("there is no ClassFileBody associated with non-concrete methods!");
        

	// xxx  fix api here for MethodSource
	MethodSource ms = method.getSource();
	if(ms instanceof CoffiMethodSource) {
	    this.coffiClass =  ((CoffiMethodSource)ms).coffiClass;
	    this.coffiMethod = ((CoffiMethodSource)ms).coffiMethod;
	}       
    }

    public Object clone() 
    { throw new UnsupportedOperationException("can't clone ClassfileBody"); }
}



