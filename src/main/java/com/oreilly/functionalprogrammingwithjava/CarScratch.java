package com.oreilly.functionalprogrammingwithjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface CarCriterion {
    boolean test(Car car);
}




public class CarScratch {

    static <E> Criterion<E> negate(Criterion<E> crit) {
        return x -> !crit.test(x);
    }

    static <E> Criterion<E> and(Criterion<E> firstCriterion, Criterion<E> secondCriterion) {
        return x -> firstCriterion.test(x) && secondCriterion.test(x);
    }

    static <E> Criterion<E> or(Criterion<E> firstCriterion, Criterion<E> secondCriterion) {
        return x -> firstCriterion.test(x)||secondCriterion.test(x);
    }

    static List<Car> getCarByCriterion(Iterable<Car> in, CarCriterion crit) {
        List<Car> output = new ArrayList<>();
        for (Car car: in) {
            if(crit.test(car)) {
                output.add(car);
            }
        }
        return output;
    }

    /*
    static <E> List<E> getByCriterion(Iterable<E> in, Criterion crit) {
        List<E> output = new ArrayList<>();
        for (E e: in) {
            if(crit.test(e)) {
                output.add(e);
            }
        }
        return output;
    }
    */

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

       /* showAll(getCarByCriterion(cars, Car.getRedCarCriterion()));
        showAll(getCarByCriterion(cars, new Car.GasLevelCarCriterion(6)));

        showAll(getCarByCriterion(cars, Car.getColorCriterion("Red", "Black")));*/

        Criterion<Car> colorCriterion = Car.getColorCriterion("Red", "Black");
        Criterion<Car> notRedNorBlackColors = negate(colorCriterion);

        showAll(Criterion.getByCriterion(cars, notRedNorBlackColors));
    }
}
