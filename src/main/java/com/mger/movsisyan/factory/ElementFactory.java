package com.mger.movsisyan.factory;

import com.mger.movsisyan.model.And;
import com.mger.movsisyan.model.LogicElement;
import com.mger.movsisyan.model.Or;
import com.mger.movsisyan.model.Xor;

public class ElementFactory {
    public enum Type{
        AND,
        OR,
        XOR;
    }

    public static LogicElement newInstance(Type type, int count) {
        return switch (type) {
            case AND -> new And(count);
            case OR -> new Or(count);
            case XOR -> new Xor(count);
        };
    }


}
