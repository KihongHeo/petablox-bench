/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package soot.jimple.parser.node;

import java.util.*;
import soot.jimple.parser.analysis.*;

public final class ACatchClause extends PCatchClause
{
    private TCatch _catch_;
    private PClassName _name_;
    private TIdentifier _fromId_;
    private PLabelName _fromLabel_;
    private TIdentifier _toId_;
    private PLabelName _toLabel_;
    private TIdentifier _withId_;
    private PLabelName _withLabel_;
    private TSemicolon _semicolon_;

    public ACatchClause()
    {
    }

    public ACatchClause(
        TCatch _catch_,
        PClassName _name_,
        TIdentifier _fromId_,
        PLabelName _fromLabel_,
        TIdentifier _toId_,
        PLabelName _toLabel_,
        TIdentifier _withId_,
        PLabelName _withLabel_,
        TSemicolon _semicolon_)
    {
        setCatch(_catch_);

        setName(_name_);

        setFromId(_fromId_);

        setFromLabel(_fromLabel_);

        setToId(_toId_);

        setToLabel(_toLabel_);

        setWithId(_withId_);

        setWithLabel(_withLabel_);

        setSemicolon(_semicolon_);

    }
    public Object clone()
    {
        return new ACatchClause(
            (TCatch) cloneNode(_catch_),
            (PClassName) cloneNode(_name_),
            (TIdentifier) cloneNode(_fromId_),
            (PLabelName) cloneNode(_fromLabel_),
            (TIdentifier) cloneNode(_toId_),
            (PLabelName) cloneNode(_toLabel_),
            (TIdentifier) cloneNode(_withId_),
            (PLabelName) cloneNode(_withLabel_),
            (TSemicolon) cloneNode(_semicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACatchClause(this);
    }

    public TCatch getCatch()
    {
        return _catch_;
    }

    public void setCatch(TCatch node)
    {
        if(_catch_ != null)
        {
            _catch_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _catch_ = node;
    }

    public PClassName getName()
    {
        return _name_;
    }

    public void setName(PClassName node)
    {
        if(_name_ != null)
        {
            _name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _name_ = node;
    }

    public TIdentifier getFromId()
    {
        return _fromId_;
    }

    public void setFromId(TIdentifier node)
    {
        if(_fromId_ != null)
        {
            _fromId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _fromId_ = node;
    }

    public PLabelName getFromLabel()
    {
        return _fromLabel_;
    }

    public void setFromLabel(PLabelName node)
    {
        if(_fromLabel_ != null)
        {
            _fromLabel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _fromLabel_ = node;
    }

    public TIdentifier getToId()
    {
        return _toId_;
    }

    public void setToId(TIdentifier node)
    {
        if(_toId_ != null)
        {
            _toId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _toId_ = node;
    }

    public PLabelName getToLabel()
    {
        return _toLabel_;
    }

    public void setToLabel(PLabelName node)
    {
        if(_toLabel_ != null)
        {
            _toLabel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _toLabel_ = node;
    }

    public TIdentifier getWithId()
    {
        return _withId_;
    }

    public void setWithId(TIdentifier node)
    {
        if(_withId_ != null)
        {
            _withId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _withId_ = node;
    }

    public PLabelName getWithLabel()
    {
        return _withLabel_;
    }

    public void setWithLabel(PLabelName node)
    {
        if(_withLabel_ != null)
        {
            _withLabel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _withLabel_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return _semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(_semicolon_ != null)
        {
            _semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _semicolon_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_catch_)
            + toString(_name_)
            + toString(_fromId_)
            + toString(_fromLabel_)
            + toString(_toId_)
            + toString(_toLabel_)
            + toString(_withId_)
            + toString(_withLabel_)
            + toString(_semicolon_);
    }

    void removeChild(Node child)
    {
        if(_catch_ == child)
        {
            _catch_ = null;
            return;
        }

        if(_name_ == child)
        {
            _name_ = null;
            return;
        }

        if(_fromId_ == child)
        {
            _fromId_ = null;
            return;
        }

        if(_fromLabel_ == child)
        {
            _fromLabel_ = null;
            return;
        }

        if(_toId_ == child)
        {
            _toId_ = null;
            return;
        }

        if(_toLabel_ == child)
        {
            _toLabel_ = null;
            return;
        }

        if(_withId_ == child)
        {
            _withId_ = null;
            return;
        }

        if(_withLabel_ == child)
        {
            _withLabel_ = null;
            return;
        }

        if(_semicolon_ == child)
        {
            _semicolon_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_catch_ == oldChild)
        {
            setCatch((TCatch) newChild);
            return;
        }

        if(_name_ == oldChild)
        {
            setName((PClassName) newChild);
            return;
        }

        if(_fromId_ == oldChild)
        {
            setFromId((TIdentifier) newChild);
            return;
        }

        if(_fromLabel_ == oldChild)
        {
            setFromLabel((PLabelName) newChild);
            return;
        }

        if(_toId_ == oldChild)
        {
            setToId((TIdentifier) newChild);
            return;
        }

        if(_toLabel_ == oldChild)
        {
            setToLabel((PLabelName) newChild);
            return;
        }

        if(_withId_ == oldChild)
        {
            setWithId((TIdentifier) newChild);
            return;
        }

        if(_withLabel_ == oldChild)
        {
            setWithLabel((PLabelName) newChild);
            return;
        }

        if(_semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

    }
}
