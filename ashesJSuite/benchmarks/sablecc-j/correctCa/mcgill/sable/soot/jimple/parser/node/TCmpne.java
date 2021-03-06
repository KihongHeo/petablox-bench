package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TCmpne extends Token
{
    public TCmpne()
    {
        super.setText("!=");
    }

    public TCmpne(int line, int pos)
    {
        super.setText("!=");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCmpne(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCmpne(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCmpne text.");
    }
}
