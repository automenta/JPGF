package org.grammaticalframework.pgf;

public class Pool {
    final long ref;

    public Pool(long ref) {
        this.ref = ref;
    }

    public Pool() {
        this.ref = alloc();
    }

    public static native long alloc();

    public static native void free(long ref);

    public void finalize() {
        free(ref);
    }
}
