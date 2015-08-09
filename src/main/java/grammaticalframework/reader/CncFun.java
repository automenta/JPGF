/* CncFun.java
 * Copyright (C) 2010 Grégoire Détrez, Ramona Enache
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package grammaticalframework.reader;

import java.util.Arrays;
import java.util.Objects;

public class CncFun {
    public final String name;
    public final Sequence[] sequences;
    private final int hash;

    public CncFun(String _name, Sequence[] seqs) {
        this.name = _name;
        this.sequences = seqs;
        this.hash = Objects.hash(name, sequences);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof CncFun) {
            CncFun c = (CncFun)obj;
            return (hash!=c.hash) && c.name.equals(name) && (Arrays.equals(c.sequences, sequences));
        }
        return false;
    }

    /**
     * Accessors
     */
    public String name() {
        return this.name;
    }

    public Sequence[] sequences() {
        return this.sequences;
    }

    public Sequence sequence(int index) {
        return this.sequences[index];
    }

    public Symbol symbol(int seqIndex, int symbIndex) {
        return this.sequences[seqIndex].symbol(symbIndex);
    }

    public int size() {
        return this.sequences.length;
    }

    public String toString() {
        String ss = "Name : " + name + " , Indices : ";
        for (int i = 0; i < sequences.length; i++)
            ss += (" " + sequences[i]);
        return ss;
    }
// *************
// private String name;
// private int[] inds;

// public CncFun(String _name, int[] _inds)
// {name = _name;
//  inds = _inds;
// }

// public String toString()
// {String ss = "Name : "+name + " , Indices : ";
// for(int i=0; i<inds.length; i++)
//  ss+=(" "+inds[i]);
// return ss;
// }

// public String getName(){return name;}
// public int[] getInds(){return inds;}

// ^ ^ ^ ^ ^ ^ ^
}
