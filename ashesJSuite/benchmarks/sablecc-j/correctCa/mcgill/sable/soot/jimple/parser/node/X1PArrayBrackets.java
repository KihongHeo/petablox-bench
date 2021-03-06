package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class X1PArrayBrackets extends XPArrayBrackets
{
    private XPArrayBrackets _xPArrayBrackets_;
    private PArrayBrackets _pArrayBrackets_;

    public X1PArrayBrackets()
    {
    }

    public X1PArrayBrackets(
        XPArrayBrackets _xPArrayBrackets_,
        PArrayBrackets _pArrayBrackets_)
    {
        setXPArrayBrackets(_xPArrayBrackets_);
        setPArrayBrackets(_pArrayBrackets_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPArrayBrackets getXPArrayBrackets()
    {
        return _xPArrayBrackets_;
    }

    public void setXPArrayBrackets(XPArrayBrackets node)
    {
        if(_xPArrayBrackets_ != null)
        {
            _xPArrayBrackets_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPArrayBrackets_ = node;
    }

    public PArrayBrackets getPArrayBrackets()
    {
        return _pArrayBrackets_;
    }

    public void setPArrayBrackets(PArrayBrackets node)
    {
        if(_pArrayBrackets_ != null)
        {
            _pArrayBrackets_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pArrayBrackets_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPArrayBrackets_ == child)
        {
            _xPArrayBrackets_ = null;
        }

        if(_pArrayBrackets_ == child)
        {
            _pArrayBrackets_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPArrayBrackets_) +
            toString(_pArrayBrackets_);
    }
}
