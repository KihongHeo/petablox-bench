package wig.node;

import ca.mcgill.sable.util.*;
import wig.analysis.*;

public final class AParameters1Parametersp extends PParametersp
{
    private TLeftParen _leftParen_;
    private TRightParen _rightParen_;

    public AParameters1Parametersp()
    {
    }

    public AParameters1Parametersp(
        TLeftParen _leftParen_,
        TRightParen _rightParen_)
    {
        setLeftParen(_leftParen_);

        setRightParen(_rightParen_);

    }
    public Object clone()
    {
        return new AParameters1Parametersp(
            (TLeftParen) cloneNode(_leftParen_),
            (TRightParen) cloneNode(_rightParen_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParameters1Parametersp(this);
    }

    public TLeftParen getLeftParen()
    {
        return _leftParen_;
    }

    public void setLeftParen(TLeftParen node)
    {
        if(_leftParen_ != null)
        {
            _leftParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _leftParen_ = node;
    }

    public TRightParen getRightParen()
    {
        return _rightParen_;
    }

    public void setRightParen(TRightParen node)
    {
        if(_rightParen_ != null)
        {
            _rightParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rightParen_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_leftParen_)
            + toString(_rightParen_);
    }

    void removeChild(Node child)
    {
        if(_leftParen_ == child)
        {
            _leftParen_ = null;
            return;
        }

        if(_rightParen_ == child)
        {
            _rightParen_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_leftParen_ == oldChild)
        {
            setLeftParen((TLeftParen) newChild);
            return;
        }

        if(_rightParen_ == oldChild)
        {
            setRightParen((TRightParen) newChild);
            return;
        }

    }
}