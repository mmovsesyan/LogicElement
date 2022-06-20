package com.mger.movsisyan.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class LogicElement implements Comparable<LogicElement>{
    private boolean[] mass;

    public LogicElement(int n) {
        this.mass = new boolean[n];
    }

    public void fill(boolean ...args) {
        if (args.length < mass.length) {
            throw new IllegalArgumentException("Entered array smaller ");
        }
        System.arraycopy(args, 0, mass, 0, args.length);
    }

    public int getLength() {
        return mass.length;
    }

    protected abstract boolean operation(boolean a, boolean b);

    /**
     * 5.	Реализовать метод result, производящий вычисление значения на выходе логического элемента,
     * используя n его входов и метод operation
     */
    public boolean result() {
        boolean operation = mass[0];
        for (int i = 1; i < mass.length; i++) {
           operation = operation(operation, mass[i]);
        }
        return operation;
    }

    /**
     * 6.	Реализовать метод union, принимающий на вход второй логический элемент и производящий объединение
     * двух логических элементов, возвращая новый. При несовпадении типа исходного логического элемента с типом
     * переданного аргумента сгенерировать исключение ClassCastException. Для создания объекта, динамически
     * определяя его тип, воспользоваться методами рефлексии.
     */
    public LogicElement union(LogicElement e) {
        if (this.getClass() != e.getClass()) {
            throw new ClassCastException("Elements has different types ");
        }
        try {
            LogicElement logicElement = this.getClass().getConstructor(int.class)
                    .newInstance(this.mass.length + e.mass.length);
            System.arraycopy(this.mass, 0, logicElement.mass, 0, this.mass.length);
            System.arraycopy(e.mass, 0 , logicElement.mass, this.mass.length, e.getLength());
            return logicElement;
        } catch (Exception ignored) {}
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicElement that = (LogicElement) o;
        return Arrays.equals(mass, that.mass);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mass);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{inputs:" + Arrays.toString(mass) + ", output:" + this.result() +
                '}';
    }

    @Override
    public int compareTo(LogicElement o) {
        return Boolean.compare(this.result(), o.result());
    }
}
