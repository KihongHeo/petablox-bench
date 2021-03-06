package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TNative extends Token
{
    public TNative()
    {
        super.setText("native");
    }

    public TNative(int line, int pos)
    {
        super.setText("native");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNative(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNative(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TNative text.");
    }
}
