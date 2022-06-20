package com.mger.movsisyan.repository;

import com.mger.movsisyan.factory.ElementFactory;
import com.mger.movsisyan.factory.ElementFactory1;
import com.mger.movsisyan.model.LogicElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class ElementRepository {
    private ArrayList<LogicElement> elements = new ArrayList<>();

    public ElementRepository(String fileName, Map<String, ElementFactory1> factoryHashMap) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split(";");
                    String type = split[0];
                    String[] strings = Arrays.copyOfRange(split, 1, split.length);
                    boolean[] booleans = new boolean[strings.length];
                    for (int i = 0; i < strings.length; i++) {
                        booleans[i] = Boolean.parseBoolean(strings[i]);
                    }
                    ElementFactory1 elementFactory1 = factoryHashMap.getOrDefault(type, null);
                    LogicElement logicElement = elementFactory1.newInstance(booleans.length);
                    logicElement.fill(booleans);
                    this.elements.add(logicElement);
                } catch (RuntimeException ignored) {}
            }
        }
    }

    public ElementRepository(String name) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            while (bufferedReader.ready()) {
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split(";");
                    String type = split[0];
                    String[] copy = Arrays.copyOfRange(split, 1, split.length);
                    boolean[] booleans = new boolean[copy.length];
                    for (int i = 0; i < copy.length; i++) {
                        booleans[i] = Boolean.parseBoolean(copy[i]);
                    }
                    LogicElement logicElement = ElementFactory.newInstance(ElementFactory.Type.valueOf(type),
                            booleans.length);
                    logicElement.fill(booleans);
                    this.elements.add(logicElement);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LogicElement element : this.elements) {
            stringBuilder.append(element).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sort(Comparator<LogicElement> comparator) {
        this.elements.sort(comparator);
    }
}
