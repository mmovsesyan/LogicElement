package com.mger.movsisyan.util;

import com.mger.movsisyan.model.LogicElement;

public class Elements{

    public LogicElement unionElement(LogicElement... e) {
        LogicElement logicElement = e[0];
        for (int i = 1; i < e.length; i++) {
            logicElement = logicElement.union(e[i]);
        }
        return logicElement;
    }
}
