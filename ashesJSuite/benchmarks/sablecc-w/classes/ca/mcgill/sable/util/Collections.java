/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * SableUtil, a clean room implementation of the Collection API.     *
 * Copyright (C) 1997, 1998 Raja Vallee-Rai (kor@sable.mcgill.ca).   *
 * All rights reserved.                                              *
 *                                                                   *
 * Modifications by Patrick Lam are                                  *
 * Copyright (C) 1998 Patrick Lam (plam@sable.mcgill.ca).  All       *
 * rights reserved.                                                  *
 *                                                                   *
 * Modifications by Etienne Gagnon (gagnon@sable.mcgill.ca) are      *
 * Copyright (C) 1998 Etienne Gagnon (gagnon@sable.mcgill.ca). All   *
 * rights reserved.                                                  *
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
 The reference version is: $SableUtilVersion: 1.11 $

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

 - Modified on August 10, 1998 by Patrick Lam (plam@sable.mcgill.ca) (*)
   Added pass-through toString to UnmodifiableList.

 - Modified on July 23, 1998 by Raja Vallee-Rai (kor@sable.mcgill.ca) (*)
   Changed some constructors to satisfy jikes.

 - Modified on July 23, 1998 by Etienne Gagnon (gagnon@sable.mcgill.ca). (*)
   Added toArray(Object[]).

 - Modified on June 15, 1998 by Patrick Lam (plam@sable.mcgill.ca). (*)
   Added UnmodifiableList and associated inner classes.

 - Modified on June 15, 1998 by Raja Vallee-Rai (kor@sable.mcgill.ca). (*)
   First release of this file.
*/

package ca.mcgill.sable.util;

public class Collections
{
  static class UnmodIterator implements Iterator
  {
    Iterator it;
    public UnmodIterator(Iterator it) { this.it = it; }

    public boolean hasNext() { return it.hasNext(); }
    public Object next() { return it.next(); }
    public void remove()
      throws UnsupportedOperationException, NoSuchElementException
      { throw new UnsupportedOperationException(); }
  }

  static class UnmodListIterator implements ListIterator
  {
    ListIterator li;

    public UnmodListIterator(ListIterator li) { this.li = li; }

    public boolean hasNext() { return li.hasNext(); }
    public Object next() throws NoSuchElementException
      { return li.next(); }
    public boolean hasPrevious() { return li.hasPrevious(); }
    public Object previous() throws NoSuchElementException
      { return li.previous(); }
    public int nextIndex() { return li.nextIndex(); }
    public int previousIndex() { return li.previousIndex(); }
    public void remove()
      throws UnsupportedOperationException, NoSuchElementException
      { throw new UnsupportedOperationException(); }
    public void set(Object o)
      throws UnsupportedOperationException, NoSuchElementException
      { throw new UnsupportedOperationException(); }
    public void add(Object o)
      throws UnsupportedOperationException
      { throw new UnsupportedOperationException(); }
  }

  static class UnmodList implements List
  {
    private List l;

    public UnmodList(List l) { this.l = l; }

    public int size() { return l.size(); }
    public boolean isEmpty() { return l.isEmpty(); }
    public boolean contains(Object o) { return l.contains(o); }
    public Object[] toArray() { return l.toArray(); }

    public void toArray(Object[] a)
    {
        l.toArray(a);
    }

    public boolean add(Object o)
      throws UnsupportedOperationException,
      ClassCastException, IllegalArgumentException
      { throw new UnsupportedOperationException(); }
    public boolean remove(Object o)
      throws UnsupportedOperationException
      { throw new UnsupportedOperationException(); }
    public boolean containsAll(Collection c) { return l.containsAll(c); }
    public boolean addAll(Collection c)
      throws UnsupportedOperationException,
      ClassCastException, IllegalArgumentException
      { throw new UnsupportedOperationException(); }
    public boolean removeAll(Collection c)
      throws UnsupportedOperationException
      { throw new UnsupportedOperationException(); }
    public boolean retainAll(Collection c)
      throws UnsupportedOperationException
      { throw new UnsupportedOperationException(); }
    public void clear()
      throws UnsupportedOperationException
      { throw new UnsupportedOperationException(); }
    public boolean equals(Object o) { return l.equals(o); }
    public int hashCode() { return l.hashCode(); }
    public Object get(int index)
      throws ArrayIndexOutOfBoundsException
      { return l.get(index); }
    public Object set(int index, Object element)
      throws UnsupportedOperationException, ClassCastException,
      IllegalArgumentException, ArrayIndexOutOfBoundsException
      { throw new UnsupportedOperationException(); }
    public void add(int index, Object element)
      throws UnsupportedOperationException, ClassCastException,
      IllegalArgumentException, ArrayIndexOutOfBoundsException
      { throw new UnsupportedOperationException(); }
    public Object remove(int index)
      throws UnsupportedOperationException, ArrayIndexOutOfBoundsException
      { throw new UnsupportedOperationException(); }
    public int indexOf(Object o) { return l.indexOf(o); }
    public int indexOf(Object o, int index)
      throws ArrayIndexOutOfBoundsException
      { return l.indexOf(o, index); }
    public int lastIndexOf(Object o) { return l.lastIndexOf(o); }
    public int lastIndexOf(Object o, int index)
      throws ArrayIndexOutOfBoundsException
      { return l.lastIndexOf(o, index); }
    public void removeRange(int fromIndex, int toIndex)
      throws UnsupportedOperationException, ArrayIndexOutOfBoundsException
      { throw new UnsupportedOperationException(); }
    public boolean addAll(int index, Collection c)
      throws UnsupportedOperationException, ClassCastException,
      IllegalArgumentException, ArrayIndexOutOfBoundsException
      { throw new UnsupportedOperationException(); }
    public String toString() { return l.toString(); }

    public Iterator iterator() { return new UnmodIterator(l.iterator()); }
    public ListIterator listIterator()
      { return new UnmodListIterator(l.listIterator()); }
    public ListIterator listIterator(int index)
      throws ArrayIndexOutOfBoundsException
      { return new UnmodListIterator(l.listIterator(index)); }
    }

  public static List unmodifiableList(List list)
    {
      return new UnmodList(list);
    }
}
