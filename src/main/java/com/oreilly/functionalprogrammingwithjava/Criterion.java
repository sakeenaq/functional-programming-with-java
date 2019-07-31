package com.oreilly.functionalprogrammingwithjava;

import java.util.ArrayList;
import java.util.List;

public interface Criterion<E> {
    boolean test(E e);

    static <E> List<E> getByCriterion(Iterable<E> in, Criterion crit) {
        List<E> output = new ArrayList<>();
        for (E e: in) {
            if(crit.test(e)) {
                output.add(e);
            }
        }
        return output;
    }
}