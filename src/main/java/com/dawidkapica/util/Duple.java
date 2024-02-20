package com.dawidkapica.util;

public class Duple<T, E> {
    private T x1;
    private E x2;

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
}
