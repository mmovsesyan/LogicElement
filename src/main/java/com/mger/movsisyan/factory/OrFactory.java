package com.mger.movsisyan.factory;

import com.mger.movsisyan.model.LogicElement;
import com.mger.movsisyan.model.Or;

public class OrFactory implements ElementFactory1{
    @Override
    public LogicElement newInstance(int count) {
        return new Or(count);
    }
}
