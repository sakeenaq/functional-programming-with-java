package com.oreilly.functionalprogrammingwithjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVersion {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen");

        strings.stream().forEach(s -> System.out.println("> " + s));

        Stream<String> upperCase = strings.stream().filter(s -> Character.isUpperCase(s.charAt(0)));

        System.out.println("-------------------------------------------------");
        upperCase.forEach(s -> System.out.println("> " + s));

        System.out.println("-------------------------------------------------");
        strings.stream().forEach(s -> System.out.println("> " + s));

       System.out.println("-------------------------------------------------");
       strings.stream().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
/*
        SuperIterable<Car> carIter = new SuperIterable<>(
                Arrays.asList(
                        Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
                        Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
                        Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
                        Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
                        Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
                )
        );
        carIter
                .filter(c -> c.getGasLevel() >= 6)
                .map(c -> c.getPassengers().get(0) + " is driving with lot of fuel" +
                        "")
                .forEach(c -> System.out.println(c));

        System.out.println("-------------------------------------------------");

        carIter
                .map(car ->  car.addGas(4))
                .forEach(car -> System.out.println(">> " + car));

        System.out.println("-------------------------------------------------");

        carIter
                .filter(c -> c.getPassengers().size() > 3)
                .flatMap(c -> new SuperIterable<>(c.getPassengers()))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));*/
    }
}
