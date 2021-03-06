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

public abstract class AbstractNewArrayExpr implements NewArrayExpr, ConvertToBaf
{
    Type baseType;
    ValueBox sizeBox;

    protected AbstractNewArrayExpr(Type type, ValueBox sizeBox)
    {
      this.baseType = type; this.sizeBox = sizeBox;
    }

    public abstract Object clone();
    
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(Jimple.v().NEWARRAY + " (" + getBaseTypeString() + ")");
        buffer.append("[" + sizeBox.getValue().toString() + "]");

        return buffer.toString();
    }

    
    public String toBriefString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(Jimple.v().NEWARRAY + " (" + getBaseTypeString() + ")");
        buffer.append("[" + ((ToBriefString) sizeBox.getValue()).toBriefString() + "]");

        return buffer.toString();
    }

  
  private  String getBaseTypeString()
  {
    if(Jimple.isJavaKeywordType(baseType))
      return "." + baseType;
    else
      return baseType.toString();
  }

    public Type getBaseType()
    {
        return baseType;
    }

    public void setBaseType(Type type)
    {
        baseType = type;
    }

    public ValueBox getSizeBox()
    {
        return sizeBox;
    }

    public Value getSize()
    {
        return sizeBox.getValue();
    }

    public void setSize(Value size)
    {
        sizeBox.setValue(size);
    }

    public List getUseBoxes()
    {
        List useBoxes = new ArrayList();

        useBoxes.addAll(sizeBox.getValue().getUseBoxes());
        useBoxes.add(sizeBox);

        return useBoxes;
    }


    public Type getType()
    {
        if(baseType instanceof ArrayType)
            return ArrayType.v(((ArrayType) baseType).baseType, ((ArrayType) baseType).numDimensions + 1);
        else
            return ArrayType.v((BaseType) baseType, 1);
    }

    public void apply(Switch sw)
    {
        ((ExprSwitch) sw).caseNewArrayExpr(this);
    }

    public void convertToBaf(JimpleToBafContext context, List out)
    {
       ((ConvertToBaf)(getSize())).convertToBaf(context, out);

        out.add(Baf.v().newNewArrayInst(getBaseType()));
    }
}
