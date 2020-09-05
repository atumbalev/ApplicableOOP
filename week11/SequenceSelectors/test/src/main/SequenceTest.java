package main;

import java.util.Random;

import iterators7c.SelectorBackward;
import iterators7c.SelectorForward;
import iterators7c.SelectorTwoWay;
import iterators7c.Sequence;

public class SequenceTest {

    public static void main(String[] args) {
        // (1)създайте Sequence последователност от 8 елемента //
        final int SIZE = 8;
        Sequence sequence = new Sequence();
        // (2)инициализирайте Sequence елементите със случайни цели числа от интервала [10, 100]
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int n = 10 + random.nextInt(91);
            sequence.add(n);
        }

        // (3)използвайте метода getSelector(),за да разпечатате тези числа на конзолата
        // от първия до последния елемент на последователността
        SelectorForward selector = sequence.getSelectorForward();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        // (4)използвайте метода getRSelector(),за да разпечатате на конзолата тези числа
        // от последния елемент до първия на последователността

        SelectorBackward reverseSelector = sequence.getSelectorBackward();
        while (!reverseSelector.begin()) {
            System.out.println(reverseSelector.current());
            reverseSelector.previous();
        }

        SelectorTwoWay selectorTwoWay = sequence.getSelectorTwoWay(0);
        while (!selectorTwoWay.end()) {
            System.out.println(selectorTwoWay.current());
            selectorTwoWay.next();
        }

        while(!selectorTwoWay.begin()) {
            System.out.println(selectorTwoWay.current());
            selectorTwoWay.previous();
        }

    }

}
