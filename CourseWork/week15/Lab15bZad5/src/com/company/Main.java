package com.company;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {

    public static void main(String[] args) {
        IntegerProperty integerProperty = new SimpleIntegerProperty(3);

        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
//        d1.bind(d2); // unidirectional d2.set(3) -> d1 = 3, d1.set(3) -> cannot set binded value
//        d1.bind(d2.multiply(2));
        d1.bind(d2.add(2));
        System.out.println("d1 is " + d1.getValue() + " and d2 is " +
                d2.getValue());
        d2.setValue(70.2);
        System.out.println("d1 is " + d1.getValue() + " and d2 is " +
                d2.getValue());
    }
}
