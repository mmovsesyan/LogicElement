package com.mger.movsisyan.model;

public class Or extends LogicElement {
    public Or(int n) {
        super(n);
    }

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a || b;
    }
}
