package com.oreilly.functionalprogrammingwithjava;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SumIntStream {

    public static void main(String[] args) {
        OptionalInt sum = IntStream.iterate(0, i -> i + 1)
                .limit(100)
                .reduce((a, b) -> a + b);
        //.forEach(i -> System.out.println(" > " + i))

        sum.ifPresent(s -> System.out.println(" >> Sum is " + s));
    }
}
