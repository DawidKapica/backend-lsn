package com.dawidkapica.util;

import java.util.Objects;

public class Duple<T, E> {
    private final T x1;
    private final E x2;

    public Duple(T x1, E x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public T getX1() {
        return x1;
    }

    public E getX2() {
        return x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duple<?, ?> duple = (Duple<?, ?>) o;
        return Objects.equals(x1, duple.x1) && Objects.equals(x2, duple.x2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2);
    }
}
