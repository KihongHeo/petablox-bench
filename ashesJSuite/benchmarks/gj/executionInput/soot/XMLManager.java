package soot;

import java.lang.*;
import java.util.*;



public class XMLManager 
{

    static public String getXML(SootMethod m)
    {
	StringBuffer buffer = new StringBuffer("    <method name=\"");
	buffer.append(XMLManager.filter(new StringBuffer(m.getName())).toString());
        buffer.append("\" type=\"");
        buffer.append(m.getReturnType().getXML());
	buffer.append("\" modifiers=\"");
	buffer.append(m.getModifiers());
        buffer.append("\">\n");

        Iterator typeIt = m.getParameterTypes().iterator();

        while(typeIt.hasNext())
        {
            buffer.append("        <parameter type=\""+ ((Type)typeIt.next()).getXML()+"\"/>\n");
        }
        buffer.append("    </method>\n");

        return buffer.toString();
    }

    static public String getXML(SootField f)
    {
	StringBuffer buffer = new StringBuffer("    <field name=\"");
	buffer.append(f.getName());
        buffer.append("\" type=\"");
        buffer.append(f.getType().getXML());
        buffer.append("\" modifiers=\"");
	buffer.append(f.getModifiers());
        buffer.append("\"/>\n");
        return buffer.toString();	
    }
    
    static public String getXML(SootClass c)
    {
	StringBuffer buffer = new StringBuffer("<class name=\"");
        buffer.append(c.getName());
        buffer.append("\" modifiers=\""+c.getModifiers()+"\" superClass=\"");
	try {
	    buffer.append(c.getSuperclass());
	} catch (NoSuperclassException e) {
	    if(!c.getName().equals("java.lang.Object"))
		throw e;	    
	}
	
        buffer.append("\">\n");

	//        buffer.append("<interfaces>\n");
        Iterator interfacesIt = c.getInterfaces().iterator();
        while (interfacesIt.hasNext())
        {
            buffer.append("    <interface name=\"");
            buffer.append(interfacesIt.next());
            buffer.append("\"/>\n");
        }
	//        buffer.append("</interfaces>\n");

	//        buffer.append("<fields>\n");
        Iterator fieldsIt = c.getFields().iterator();
        while (fieldsIt.hasNext())
            buffer.append(((SootField)fieldsIt.next()).getXML());
	//        buffer.append("</fields>\n");

	//        buffer.append("<methods>\n");
        Iterator methodsIt = c.getMethods().iterator();
        while (methodsIt.hasNext())
            buffer.append(((SootMethod)methodsIt.next()).getXML());
	//        buffer.append("</methods>\n");

        buffer.append("</class>\n");

        return buffer.toString();
    }
    
    static public String getXML(Type aType) 
    {
	return XMLManager.jasminDescriptorOf(aType);
    }
    
    //xxx  taken from jasmin class.
    static String jasminDescriptorOf(Type type)
    {
        TypeSwitch sw;

        type.apply(sw = new TypeSwitch()
        {
            public void caseBooleanType(BooleanType t)
            {
                setResult("Z");
            }

            public void caseByteType(ByteType t)
            {
                setResult("B");
            }

            public void caseCharType(CharType t)
            {
                setResult("C");
            }

            public void caseDoubleType(DoubleType t)
            {
                setResult("D");
            }

            public void caseFloatType(FloatType t)
            {
                setResult("F");
            }

            public void caseIntType(IntType t)
            {
                setResult("I");
            }

            public void caseLongType(LongType t)
            {
                setResult("J");
            }

            public void caseShortType(ShortType t)
            {
                setResult("S");
            }

            public void defaultCase(Type t)
            {
                throw new RuntimeException("Invalid type: " + t);
            }

            public void caseArrayType(ArrayType t)
            {
                StringBuffer buffer = new StringBuffer();

                for(int i = 0; i < t.numDimensions; i++)
                    buffer.append("[");

                setResult(buffer.toString() + jasminDescriptorOf(t.baseType));
            }

            public void caseRefType(RefType t)
            {
                setResult("L" + t.className.replace('.', '/') + ";");
            }

            public void caseVoidType(VoidType t)
            {
                setResult("V");
            }
        });

        return (String) sw.getResult();

    }
    
    static private StringBuffer filter(StringBuffer buffer)
    {	
	int currentLength = buffer.length();
	for(int i = 0; i< currentLength; i++) {
	    if(buffer.charAt(i) == '<') {
		i +=2; currentLength +=2;
	    }
	    else if(buffer.charAt(i)  == '>') {
		i += 2; currentLength +=2;
	    }
	}
	return buffer;
    }
    
}
