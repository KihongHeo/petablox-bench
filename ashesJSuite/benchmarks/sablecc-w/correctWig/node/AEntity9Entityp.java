package wig.node;

import ca.mcgill.sable.util.*;
import wig.analysis.*;

public final class AEntity9Entityp extends PEntityp
{
    private PEntity9p _entity9p_;
    private PStringp _stringp_;
    private TQuote _quote_;
    private TClose _close_;

    public AEntity9Entityp()
    {
    }

    public AEntity9Entityp(
        PEntity9p _entity9p_,
        PStringp _stringp_,
        TQuote _quote_,
        TClose _close_)
    {
        setEntity9p(_entity9p_);

        setStringp(_stringp_);

        setQuote(_quote_);

        setClose(_close_);

    }
    public Object clone()
    {
        return new AEntity9Entityp(
            (PEntity9p) cloneNode(_entity9p_),
            (PStringp) cloneNode(_stringp_),
            (TQuote) cloneNode(_quote_),
            (TClose) cloneNode(_close_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEntity9Entityp(this);
    }

    public PEntity9p getEntity9p()
    {
        return _entity9p_;
    }

    public void setEntity9p(PEntity9p node)
    {
        if(_entity9p_ != null)
        {
            _entity9p_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _entity9p_ = node;
    }

    public PStringp getStringp()
    {
        return _stringp_;
    }

    public void setStringp(PStringp node)
    {
        if(_stringp_ != null)
        {
            _stringp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _stringp_ = node;
    }

    public TQuote getQuote()
    {
        return _quote_;
    }

    public void setQuote(TQuote node)
    {
        if(_quote_ != null)
        {
            _quote_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _quote_ = node;
    }

    public TClose getClose()
    {
        return _close_;
    }

    public void setClose(TClose node)
    {
        if(_close_ != null)
        {
            _close_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _close_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_entity9p_)
            + toString(_stringp_)
            + toString(_quote_)
            + toString(_close_);
    }

    void removeChild(Node child)
    {
        if(_entity9p_ == child)
        {
            _entity9p_ = null;
            return;
        }

        if(_stringp_ == child)
        {
            _stringp_ = null;
            return;
        }

        if(_quote_ == child)
        {
            _quote_ = null;
            return;
        }

        if(_close_ == child)
        {
            _close_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_entity9p_ == oldChild)
        {
            setEntity9p((PEntity9p) newChild);
            return;
        }

        if(_stringp_ == oldChild)
        {
            setStringp((PStringp) newChild);
            return;
        }

        if(_quote_ == oldChild)
        {
            setQuote((TQuote) newChild);
            return;
        }

        if(_close_ == oldChild)
        {
            setClose((TClose) newChild);
            return;
        }

    }
}
