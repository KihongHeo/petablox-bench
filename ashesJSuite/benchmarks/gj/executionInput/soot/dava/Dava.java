package soot.dava;

import java.util.*;
import soot.*;
import soot.dava.internal.*;
import soot.jimple.*;


public class Dava
{
    private static Dava instance = new Dava();

    public static Dava v() 
    {
        return instance;
    }

    private Dava() 
    {
    }

    public EmptyTrunk newEmptyTrunk()
    {
        return new DEmptyTrunk();
    }

    public DavaBody newBody(SootMethod m)
    {
        return new DavaBody( m);
    }

        /** Returns a DavaBody constructed from b. */
    public DavaBody newBody(Body b, String phase)
    {
        Map options = Scene.v().computePhaseOptions(phase, "");
        return new DavaBody(b, options);
    }

    /** Returns a DavaBody constructed from b. */
    public DavaBody newBody(Body b, String phase, String optionsString)
    {
        Map options = Scene.v().computePhaseOptions(phase, optionsString);
        return new DavaBody(b, options);
    }

    
    public Local newLocal(String name, Type t)
    {
        return Jimple.v().newLocal(name, t);
    }
    
    public IfElseTrunk newIfElseTrunk(ConditionExpr e, Trunk ifTrunk, Trunk elseTrunk)
    {
        return new IfElseTrunk(e, ifTrunk, elseTrunk);
    }
    
}






