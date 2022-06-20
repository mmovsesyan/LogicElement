package com.mger.movsisyan.program;

import com.mger.movsisyan.factory.*;
import com.mger.movsisyan.model.LogicElement;
import com.mger.movsisyan.repository.ElementRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
//        LogicElement logicElement = new And(5);
//        logicElement.fill(true, false, true, true, false);
//        LogicElement logicElement1 = new And(5);
//        logicElement1.fill(true, false, false, true, false);
//        System.out.println(logicElement.result());
//        System.out.println(logicElement.union(logicElement1));

        try {
            ElementRepository repository = new ElementRepository("elements.csv");
            System.out.println(repository);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            HashMap<String, ElementFactory1> factoryHashMap = new HashMap<>();
            factoryHashMap.put("AND", new AndFactory());
            factoryHashMap.put("OR", new OrFactory());
            factoryHashMap.put("XOR", new XorFactory());
            ElementRepository repository = new ElementRepository("elements.csv", factoryHashMap);
            System.out.println(repository);
            repository.sort(null);
            System.out.println(repository);
            repository.sort(new Comparator<LogicElement>() {
                @Override
                public int compare(LogicElement o1, LogicElement o2) {
                    return Integer.compare(o1.getLength(), o2.getLength());
                }
            });
            System.out.println(repository);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
