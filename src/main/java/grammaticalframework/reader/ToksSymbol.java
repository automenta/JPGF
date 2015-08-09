/* ToksSymbol.java
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

public class ToksSymbol extends Symbol {

    private final int hash;
    public final String[] toks;

    /**
     * Constructor
     */
    public ToksSymbol(String[] _toks) {
        toks = _toks;
        this.hash = Arrays.hashCode(toks);
    }

    /**
     * Accessors
     */
    public String[] tokens() {
        return this.toks;
    }

    public boolean isTerminal() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToksSymbol that = (ToksSymbol) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (that.hash != hash && !Arrays.equals(toks, that.toks)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    public String toString() {
        String s = "Tokens : ";
        for (int i = 0; i < toks.length; i++)
            s += (' ' + toks[i]);
        return s;
    }
}
