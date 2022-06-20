package com.mger.movsisyan.factory;

import com.mger.movsisyan.model.LogicElement;

public class AndFactory implements ElementFactory1 {
    @Override
    public LogicElement newInstance(int count) {
        return new com.mger.movsisyan.model.And(count);
    }
}
