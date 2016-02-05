/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * SableCC, an object-oriented compiler framework.                   *
 * Copyright (C) 1997, 1998 Etienne Gagnon (gagnon@sable.mcgill.ca). *
 * All rights reserved.                                              *
 *                                                                   *
 * This work was done as a project of the Sable Research Group,      *
 * School of Computer Science, McGill University, Canada             *
 * (http://www.sable.mcgill.ca/).  It is understood that any         *
 * modification not identified as such is not covered by the         *
 * preceding statement.                                              *
 *                                                                   *
 * This work is free software; you can redistribute it and/or        *
 * modify it under the terms of the GNU Library General Public       *
 * License as published by the Free Software Foundation; either      *
 * version 2 of the License, or (at your option) any later version.  *
 *                                                                   *
 * This work is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU *
 * Library General Public License for more details.                  *
 *                                                                   *
 * You should have received a copy of the GNU Library General Public *
 * License along with this library; if not, write to the             *
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,      *
 * Boston, MA  02111-1307, USA.                                      *
 *                                                                   *
 * To submit a bug report, send a comment, or get the latest news on *
 * this project and other Sable Research Group projects, please      *
 * visit the web site: http://www.sable.mcgill.ca/                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/*
 Reference Version
 -----------------
 This is the latest official version on which this file is based.
 The reference version is: $SableCCVersion: 2.8 $

 Change History
 --------------
 A) Notes:

 Please use the following template.  Most recent changes should
 appear at the top of the list.

 - Modified on [date (March 1, 1900)] by [name]. [(*) if appropriate]
   [description of modification].

 Any Modification flagged with "(*)" was done as a project of the
 Sable Research Group, School of Computer Science,
 McGill University, Canada (http://www.sable.mcgill.ca/).

 You should add your copyright, using the following template, at
 the top of this file, along with other copyrights.

 *                                                                   *
 * Modifications by [name] are                                       *
 * Copyright (C) [year(s)] [your name (or company)].  All rights     *
 * reserved.                                                         *
 *                                                                   *

 B) Changes:

 - Modified on June 7, 1998 by Etienne Gagnon (gagnon@sable.mcgill.ca). (*)
   Changed the license.
*/

package ca.mcgill.sable.sablecc.node;

import ca.mcgill.sable.sablecc.util.Switch;
import ca.mcgill.sable.sablecc.analysis.Analysis;

public final class UnExp1 extends UnExp
{
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseUnExp1(this);
    }

    public String toString()
    {
        return ""
            + node1
            + node2;
    }

    private Basic node1;

    public Basic getNode1()
    {
        return node1;
    }

    public void setNode1(Basic node)
    {
        if(node1 != null)
        {
            node1.setParent(null);
        }

        if(node.getParent() != null)
        {
            node.getParent().removeChild(node);
        }

        node.setParent(this);

        node1 = node;
    }

    private UnOpOpt node2;

    public UnOpOpt getNode2()
    {
        return node2;
    }

    public void setNode2(UnOpOpt node)
    {
        if(node2 != null)
        {
            node2.setParent(null);
        }

        if(node.getParent() != null)
        {
            node.getParent().removeChild(node);
        }

        node.setParent(this);

        node2 = node;
    }

    void removeChild(Node child)
    {
        if(node1 == child)
        {
            node1 = null;
        }

        if(node2 == child)
        {
            node2 = null;
        }

    }
}
