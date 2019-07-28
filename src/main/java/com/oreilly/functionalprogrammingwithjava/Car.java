package com.oreilly.functionalprogrammingwithjava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.Predicate;

@Data @AllArgsConstructor
public class Car {
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    public static Car withGasColorPassengers(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, null);
        return self;
    }

    public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
        return self;
    }

    public Car addGas(int g) {
        return new Car(gasLevel + g, color, passengers, trunkContents);
    }

    public Optional<List<String>> getTrunkContentsOpt() {
        return Optional.ofNullable(trunkContents);
    }
/*

    public static Predicate<Car> getColorCriterion(String ... colors) {
        Set<String> colorSet = new TreeSet<>(Arrays.asList(colors));
        return c -> colorSet.contains(c.getColor());
    }

    public static Predicate<Car> getRedCarCriterion() {
        return RED_CAR_CRITERION;
    }

    private static final Predicate<Car> RED_CAR_CRITERION
            = c -> c.color.equals("Red");

    public static Predicate<Car> getGasLevelCarCriterion(final int threshold) {
        return c -> c.gasLevel >= threshold;
    }

    public static Predicate<Car> getFourPassengerCriterion() {
        return c -> c.passengers.size() >= 4;
    }

    public static Comparator<Car> getFuelComparator() {
        return fuelComparator;
    }

    private static final Comparator<Car> fuelComparator = (o1, o2) -> o1.gasLevel - o2.gasLevel;
*/

    public static CarCriterion getRedCarCriterion() {
        return RED_CAR_CRITERION;
    }

    private static final CarCriterion RED_CAR_CRITERION = new CarCriterion() {
        @Override
        public boolean test(Car car) {
            return car.getColor().equals("Red");
        }
    };


    static class GasLevelCarCriterion implements CarCriterion {

        private int level;

        public GasLevelCarCriterion(int level) {
            this.level = level;
        }

        @Override
        public boolean test(Car car) {
            return car.getGasLevel() >= level;
        }
    }


}
