package com.mger.movsisyan.model;

public class And extends LogicElement {

    public And(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a && b;
    }
}
