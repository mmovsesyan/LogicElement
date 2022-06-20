package com.mger.movsisyan.factory;

import com.mger.movsisyan.model.LogicElement;
import com.mger.movsisyan.model.Xor;

public class XorFactory implements ElementFactory1{
    @Override
    public LogicElement newInstance(int count) {
        return new Xor(count);
    }
}
