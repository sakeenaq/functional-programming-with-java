package com.oreilly.functionalprogrammingwithjava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    static <E> List<E> getByPredicate(Iterable<E> in, Predicate crit) {
        List<E> output = new ArrayList<>();
        for (E e: in) {
            if(crit.test(e)) {
                output.add(e);
            }
        }
        return output;
    }

    default Criterion<E> negate() {
        return x -> !this.test(x);
    }

    default Criterion<E> and(Criterion<E> secondCriterion) {
        return x -> this.test(x) && secondCriterion.test(x);
    }

    default Criterion<E> or(Criterion<E> secondCriterion) {
        return x -> this.test(x)||secondCriterion.test(x);
    }
}