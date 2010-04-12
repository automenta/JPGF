/*
 * BasicUnlexer.java
 * Copyright (C) 2004-2006, Bjorn Bringert (bringert@cs.chalmers.se)
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
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package se.chalmers.cs.gf.linearize.unlex;

import se.chalmers.cs.gf.linearize.gfvalue.*;
import se.chalmers.cs.gf.parse.Token;

import java.util.Iterator;
import java.util.List;

/**
 *  An unlexer that separates all tokens with a single space,
 *  and does not transform any tokens.
 */
public class BasicUnlexer implements Unlexer {

	public String unlex(List<Token> tokens) {
		if (tokens.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder();
		Iterator<Token> it = tokens.iterator();

		Token t1 = null;
		Token t2 = null;
		Token t3 = it.next();

		while (it.hasNext()) {
			t1 = t2;
			t2 = t3;
			t3 = it.next();	
			sb.append(format(t1,t2,t3));
		}
		sb.append(format(t2,t3,null));

		return sb.toString();
	}


	protected String format(Token before, Token t, Token after) {
		return t.getValue() + (after == null ? "" : " ");
	}

}
