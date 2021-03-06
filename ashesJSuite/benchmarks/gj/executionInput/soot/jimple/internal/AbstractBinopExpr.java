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





package soot.jimple.internal;

import soot.*;
import soot.jimple.*;
import soot.util.*;
import java.util.*;

public abstract class AbstractBinopExpr implements Expr, ToBriefString
{
    protected ValueBox op1Box;
    protected ValueBox op2Box;

    public Value getOp1()
    {
        return op1Box.getValue();
    }

    public Value getOp2()
    {
        return op2Box.getValue();
    }

    public ValueBox getOp1Box()
    {
        return op1Box;
    }

    public ValueBox getOp2Box()
    {
        return op2Box;
    }

    public void setOp1(Value op1)
    {
        op1Box.setValue(op1);
    }

    public void setOp2(Value op2)
    {
        op2Box.setValue(op2);
    }

    public List getUseBoxes()
    {
        List list = new ArrayList();

        list.addAll(op1Box.getValue().getUseBoxes());
        list.add(op1Box);
        list.addAll(op2Box.getValue().getUseBoxes());
        list.add(op2Box);

        return list;
    }

    abstract protected String getSymbol();
    abstract public Object clone();

    public String toString()
    {
        Value op1 = op1Box.getValue(), op2 = op2Box.getValue();
        String leftOp = op1.toString(), rightOp = op2.toString();

        return leftOp + getSymbol() + rightOp;
    }

    public String toBriefString()
    {
        Value op1 = op1Box.getValue(), op2 = op2Box.getValue();
        String leftOp = ((ToBriefString)op1).toBriefString(), 
            rightOp = ((ToBriefString)op2).toBriefString();

        return leftOp + getSymbol() + rightOp;
    }
}
