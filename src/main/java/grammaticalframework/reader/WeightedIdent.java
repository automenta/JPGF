/* WeightedIdent.java
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

public class WeightedIdent {
    private final double weight;
    private final String ident;

    public WeightedIdent(String i, double weight) {
        this.ident = i;
        this.weight = weight;
    }

    public String ident() {
        return this.ident;
    }

    public double weight() {
        return this.weight;
    }

    /**
     * weight, returned as a percent (0..100)
     */
    public int weightPercent() {
        return (int) (weight * 100.0);
    }

    @Override
    public String toString() {
        return ident + '(' + weightPercent() + "%)";
    }
}
