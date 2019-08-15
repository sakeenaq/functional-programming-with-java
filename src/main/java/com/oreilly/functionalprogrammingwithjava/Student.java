package com.oreilly.functionalprogrammingwithjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private static final NavigableMap<Integer, String> gradeLetters = new TreeMap<>();

    static {
        gradeLetters.put(90, "A");
        gradeLetters.put(80, "B");
        gradeLetters.put(70, "C");
        gradeLetters.put(60, "D");
        gradeLetters.put(50, "E");
        gradeLetters.put(0, "F");
    }

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLetterGrade() {
        return  gradeLetters.floorEntry(score).getValue();
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade=" + getLetterGrade() +
                '}';
    }

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
            new Student("Fred", 71),
                new Student("Jim", 38),
                new Student("Sheila", 97),
                new Student("Weatherwax", 100),
                new Student("Ogg", 56),
                new Student("Rincewind", 28),
                new Student("Ridcully", 65),
                new Student("Magrat", 79),
                new Student("Valentine", 93),
                new Student("Gillian", 87),
                new Student("Anne", 91),
                new Student("Dr. Mahmoud", 88),
                new Student("Ender", 91),
                new Student("Hyrum", 72),
                new Student("Loke", 91),
                new Student("Bonzo", 57)
        );

        school.forEach(student -> System.out.println(student));

        System.out.println("--------------------------------");

        //Comparator<Map.Entry<String, List<Student>>> comparator = (e1, e2) -> e2.getKey().compareTo(e1.getKey());

        Comparator<Map.Entry<String, List<Student>>> comparator = Map.Entry.comparingByKey();

        Map<String, List<Student>> table = school.stream()
                .collect(Collectors.groupingBy(student -> student.getLetterGrade()));

        //System.out.println(table);

        table.entrySet().stream()
                .sorted(comparator.reversed())
                .forEach(e -> System.out.println("Students " + e.getValue() + " has grade " + e.getKey()));

        Map<String, Long> table2 = school.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getLetterGrade(),
                        Collectors.counting()
                ));

        System.out.println("--------------------------------");

        table2.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getValue() + " Students " + " have grade " + e.getKey()));

        Map<String, String> table3 = school.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getLetterGrade(),
                        Collectors.collectingAndThen(Collectors.toList(), students -> students.stream()
                                .map(student -> student.getName())
                                .collect(Collectors.joining(",")))
                ));

        System.out.println("--------------------------------");

        table3.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getValue() + " Students " + " have grade " + e.getKey()));
    }
}
