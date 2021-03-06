package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TCmpge extends Token
{
    public TCmpge()
    {
        super.setText(">=");
    }

    public TCmpge(int line, int pos)
    {
        super.setText(">=");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCmpge(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCmpge(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCmpge text.");
    }
}
