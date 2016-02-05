package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TDouble extends Token
{
    public TDouble()
    {
        super.setText("double");
    }

    public TDouble(int line, int pos)
    {
        super.setText("double");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TDouble(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDouble(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TDouble text.");
    }
}