package com.mger.movsisyan.model;

public class Xor extends LogicElement {

    public Xor(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a ^ b;
    }
}
