/* ApplProduction.java
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

public class ApplProduction extends Production {

    public final CncFun function;
    public final int[] domain;
    private final int hash;

    public ApplProduction(int fId, CncFun function, int[] domain) {
        super(0, fId);
        this.function = function;
        this.domain = domain;
        this.hash = 31 * function.hashCode() + Arrays.hashCode(domain);
    }


    public CncFun getFunction() {
        return function;
    }

    public int[] getArgs() {
        return domain;
    }

    public String toString() {
        // String ss =  "Fuction : "+ function + " Arguments : ["; 
        // for(int i=0; i<domain.length; i++)
        //     ss+=(" " + domain[i]);
        // ss+="]";
        // return ss;
        String s = "";
        s += this.fId;
        s += " -> ";
        s += this.function.name();
        s += "[ ";
        for (int c : this.domain)
            s += c + " ";
        s += "]";
        return s;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplProduction that = (ApplProduction) o;

        if (!function.equals(that.function)) return false;
        if (!Arrays.equals(domain, that.domain)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
