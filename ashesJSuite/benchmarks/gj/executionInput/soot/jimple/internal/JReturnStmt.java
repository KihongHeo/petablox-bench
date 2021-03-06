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
import soot.baf.*;
import soot.jimple.*;
import soot.util.*;
import java.util.*;

public class JReturnStmt extends AbstractStmt implements ReturnStmt
{
    ValueBox returnValueBox;

    public JReturnStmt(Value returnValue)
    {
        this(Jimple.v().newImmediateBox(returnValue));
    }

    protected JReturnStmt(ValueBox returnValueBox)
    {
        this.returnValueBox = returnValueBox;
    }

    public Object clone() 
    {
        return new JReturnStmt(Jimple.cloneIfNecessary(getOp()));
    }

    protected String toString(boolean isBrief, Map stmtToName, String indentation)
    {
        if(isBrief)
            return indentation + Jimple.v().RETURN + " "  + ((ToBriefString) returnValueBox.getValue()).toBriefString();
        else
            return indentation + Jimple.v().RETURN + " "  + returnValueBox.getValue().toString();
    }
    
    public ValueBox getOpBox()
    {
        return returnValueBox;
    }

    public void setOp(Value returnValue)
    {
        returnValueBox.setValue(returnValue);
    }

    public Value getOp()
    {
        return returnValueBox.getValue();
    }

    public List getUseBoxes()
    {
        List useBoxes = new ArrayList();

        useBoxes.addAll(returnValueBox.getValue().getUseBoxes());
        useBoxes.add(returnValueBox);

        return useBoxes;
    }

    public void apply(Switch sw)
    {
        ((StmtSwitch) sw).caseReturnStmt(this);
    }

    public void convertToBaf(JimpleToBafContext context, List out)
    {
       ((ConvertToBaf)(getOp())).convertToBaf(context, out);

        out.add(Baf.v().newReturnInst(getOp().getType()));
    }

     
    public boolean fallsThrough(){return false;}        
    public boolean branches(){return false;}


}

