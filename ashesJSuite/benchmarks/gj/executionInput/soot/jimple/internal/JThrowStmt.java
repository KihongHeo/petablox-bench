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
import soot.baf.*;
import soot.jimple.*;
import java.util.*;

public class JThrowStmt extends AbstractStmt implements ThrowStmt
{
    ValueBox opBox;

    public JThrowStmt(Value op)
    {
        this(Jimple.v().newImmediateBox(op));
    }

    protected JThrowStmt(ValueBox opBox)
    {
        this.opBox = opBox;
    }

    public Object clone() 
    {
        return new JThrowStmt(Jimple.cloneIfNecessary(getOp()));
    }

    public ValueBox getOpBox()
    {
        return opBox;
    }

    public Value getOp()
    {
        return opBox.getValue();
    }

    public void setOp(Value op)
    {
        opBox.setValue(op);
    }

    protected String toString(boolean isBrief, Map stmtToName, String indentation)
    {
        if(isBrief)
            return indentation + ".throw " + " " + ((ToBriefString) opBox.getValue()).toBriefString();
        else
            return indentation + ".throw " + opBox.getValue().toString();
    }

    public List getUseBoxes()
    {
        List useBoxes = new ArrayList();

        useBoxes.addAll(opBox.getValue().getUseBoxes());
        useBoxes.add(opBox);

        return useBoxes;
    }

    public void apply(Switch sw)
    {
        ((StmtSwitch) sw).caseThrowStmt(this);
    }    


    public void convertToBaf(JimpleToBafContext context, List out)
    {
        ((ConvertToBaf)getOp()).convertToBaf(context, out);
        out.add(Baf.v().newThrowInst());
    }


    
    public boolean fallsThrough(){return false;}
    public boolean branches(){return false;}



}
