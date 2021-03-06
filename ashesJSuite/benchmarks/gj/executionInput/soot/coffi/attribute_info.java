/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997 Clark Verbrugge
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






package soot.coffi;

import java.io.*;

/** Generic superclass for all attributes.
 * @author Clark Verbrugge
 */
class attribute_info {
   /** String by which a SourceFile attribute is recognized.
    * @see SourceFile_attribute
    */
   public static final String SourceFile = "SourceFile";
   /** String by which a ConstantValue attribute is recognized.
    * @see ConstantValue_attribute
    */
   public static final String ConstantValue = "ConstantValue";
   /** String by which a Code attribute is recognized.
    * @see Code_attribute
    */
   public static final String Code = "Code";
   /** String by which an Exceptions attribute is recognized.
    * @see Exceptions_attribute
    */
   public static final String Exceptions = "Exceptions";
   /** String by which a LineNumberTable attribute is recognized.
    * @see LineNumberTable_attribute
    */
   public static final String LineNumberTable = "LineNumberTable";
   /** String by which a LocalVariableTable attribute is recognized.
    * @see LocalVariableTable_attribute
    */
   public static final String LocalVariableTable = "LocalVariableTable";

   /** Constant pool index of the name of this attribute; should be a utf8 String
    * matching one of the constant Strings define here.
    * @see attribute_info#SourceFile
    * @see attribute_info#ConstantValue
    * @see attribute_info#Code
    * @see attribute_info#Exceptions
    * @see attribute_info#LineNumberTable
    * @see attribute_info#LocalVariableTable
    * @see CONSTANT_Utf8_info
    */
   public int attribute_name;
   /** Length of attribute in bytes. */
   public long attribute_length;
}
