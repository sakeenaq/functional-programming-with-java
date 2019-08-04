package com.oreilly.functionalprogrammingwithjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {

    private Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }

    public SuperIterable<E> filter(Predicate<E> pred) {
        List<E> output = new ArrayList<>();
        /*
        for(E e : self) {
            if(pred.test(e)) {
                output.add(e);
            }
        }
        */
        self.forEach(e -> {
            if(pred.test(e)) output.add(e);
        });
        return new SuperIterable<>(output);
    }

    /*public void forEvery(Consumer<E> cons) {
        for (E e : self) {
            cons.accept(e);
        }
    }*/

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }

    public static void main(String[] args) {
        SuperIterable<String> strings = new SuperIterable<>(
                Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen")
        );

        strings.forEach(s -> System.out.println("> " + s));

        SuperIterable<String> upperCase = strings.filter(s -> Character.isUpperCase(s.charAt(0)));

        System.out.println("-------------------------------------------------");
        upperCase.forEach(s -> System.out.println("> " + s));

        System.out.println("-------------------------------------------------");
        strings.forEach(s -> System.out.println("> " + s));
    }
}
