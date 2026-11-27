package com.example.javaspring.learning;

public class CodingExercises {
    
    public static void main(String[] args) {
        System.out.println(hello());
        System.out.println("Hello World");
        System.out.println(convertHoursToMinutes(24));
        System.out.println(convertDaysToMinutes(1));
    }

    public static int hello () {
        return 1;
    }

    public static int convertHoursToMinutes(int hours) {
        return hours * 60;
    }

    public static int convertDaysToMinutes(int days) {
        return days * 24 * 60;
    }
}
