package com.oreilly.functionalprogrammingwithjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface CarCriterion {
    boolean test(Car car);
}

class RedCarCriterion implements CarCriterion {
    @Override
    public boolean test(Car car) {
        return car.getColor().equals("Red");
    }
}

class GasLevelCarCriterion implements CarCriterion {

    private int level;

    public GasLevelCarCriterion(int level) {
        this.level = level;
    }

    @Override
    public boolean test(Car car) {
        return car.getGasLevel() >= level;
    }
}

public class CarScratch {

    static List<Car> getCarByCriterion(Iterable<Car> in, CarCriterion crit) {
        List<Car> output = new ArrayList<>();
        for (Car car: in) {
            if(crit.test(car)) {
                output.add(car);
            }
        }
        return output;
    }

    public static void showAll(List<Car> lc) {
        for (Car c : lc) {
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
                Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
                Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
                Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
                Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
        );
        showAll(cars);

        showAll(getCarByCriterion(cars, new RedCarCriterion()));
        showAll(getCarByCriterion(cars, new GasLevelCarCriterion(6)));
    }
}
