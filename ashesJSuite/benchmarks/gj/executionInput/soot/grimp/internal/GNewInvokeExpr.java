/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Patrick Lam
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





package soot.grimp.internal;

import soot.*;
import soot.grimp.*;
import soot.jimple.internal.*;
import soot.jimple.*;
import soot.grimp.*;
import soot.jimple.internal.*;
import soot.util.*;
import java.util.*;

public class GNewInvokeExpr extends AbstractStaticInvokeExpr
    implements NewInvokeExpr, Precedence
{
    RefType type;

    public GNewInvokeExpr(RefType type, SootMethod method, List args)
    {
            super(method, new ExprBox[args.size()]);

        this.type = type;
        
        for(int i = 0; i < args.size(); i++)
            this.argBoxes[i] = Grimp.v().newExprBox((Value) args.get(i));
    }

    /*
    protected GNewInvokeExpr(RefType type, ExprBox[] argBoxes)
    {
        this.type = type;
        this.argBoxes = argBoxes;
    }
    */
    
    public RefType getBaseType()
    {
        return type;
    }
    
    public void setBaseType(RefType type)
    {
        this.type = type;
    }

    public Type getType()
    {
        return type;
    }    
    
    public int getPrecedence() { return 850; }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("new " + type.toString() + "(");

        for(int i = 0; i < argBoxes.length; i++)
        {
            if(i != 0)
                buffer.append(", ");

            buffer.append(argBoxes[i].getValue().toString());
        }

        buffer.append(")");

        return buffer.toString();
    }


    public String toBriefString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("new " + 
                      ((ToBriefString) type).toBriefString() + "(");

        for(int i = 0; i < argBoxes.length; i++)
        {
            if(i != 0)
                buffer.append(", ");

            buffer.append(((ToBriefString) argBoxes[i].getValue()).toBriefString());
        }

        buffer.append(")");

        return buffer.toString();
    }

    public List getUseBoxes()
    {
        List list = new ArrayList();

        for(int i = 0; i < argBoxes.length; i++)
        {
            list.addAll(argBoxes[i].getValue().getUseBoxes());
            list.add(argBoxes[i]);
        }
        
        return list;
    }

    public void apply(Switch sw)
    {
        ((GrimpValueSwitch) sw).caseNewInvokeExpr(this);
    }
    
    public Object clone() 
    {
        ArrayList clonedArgs = new ArrayList(getArgCount());

        for(int i = 0; i < getArgCount(); i++) {
            clonedArgs.add(i, Grimp.cloneIfNecessary(getArg(i)));
            
        }
        
        return new  GNewInvokeExpr(getBaseType(), getMethod(), clonedArgs);
    }

}
