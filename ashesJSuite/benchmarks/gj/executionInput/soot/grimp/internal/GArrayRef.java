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
import soot.util.*;
import java.util.*;
import soot.jimple.*;
import soot.jimple.internal.*;

public class GArrayRef extends JArrayRef implements ArrayRef, Precedence
{
  public GArrayRef(Value base, Value index)
    {
      super(Grimp.v().newObjExprBox(base),
            Grimp.v().newExprBox(index));
    }
  
  public int getPrecedence() { return 875; }

  private String toString(Value op1, 
                          String leftOp, String rightOp)
    {
      if (op1 instanceof Precedence && 
          ((Precedence)op1).getPrecedence() < getPrecedence()) 
        leftOp = "(" + leftOp + ")";
      
      return leftOp + "[" + rightOp + "]";
    }

  public String toString()
    {
      Value op1 = getBase(), op2 = getIndex();
      String leftOp = op1.toString(), rightOp = op2.toString();
      
      return toString(op1, leftOp, rightOp);
    }

  public String toBriefString()
    {
      Value op1 = getBase(), op2 = getIndex();
      String leftOp = ((ToBriefString)op1).toBriefString(), 
        rightOp = ((ToBriefString)op2).toBriefString();
      
      return toString(op1, leftOp, rightOp);
    }    
    
    
    public Object clone() 
    {
        return new GArrayRef(Grimp.cloneIfNecessary(getBase()), Grimp.cloneIfNecessary(getIndex()));
    }

  }













