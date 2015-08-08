package org.grammaticalframework.pgf;

public class Type {
    private PGF gr;
    private long ref;

    private Type(PGF gr, long ref) {
        this.gr = gr;
        this.ref = ref;
    }

    //////////////////////////////////////////////////////////////////
    // private stuff

    public native String getCategory();

    public native Expr[] getExprs();

    public native Hypo[] getHypos();
}
