package com.example.javaspring.learning;

public class ConditionalifStatements {
    public static void main(String[] args) {

        // for (initialization; condition; update)
        // statement

        // basic examples
        int i = 6;
        if (i < 5) {
            System.out.println("int i is less than 5");
        }

        int a = 2;
        int b = 3;
        int c = 4;
        int d = 5;
        if ((a + b) < (c + d)) {
            System.out.println("int a + b is less than c + d");
        }

        // angle of triangle
        int angle1 = 20;
        int angle2 = 60;
        int angle3 = 100;
        if (angle1 + angle2 + angle3 == 180) {                // == comparison operator
            System.out.println("Valid Triangle");
        }

        // even number
        int e = 2;
        if (e % 2 == 0) {
            System.out.println("Number is even");
        }

        int k = 4;
        if(k == 5) {
            System.out.println("Number is equal to 4");
            System.out.println("Number is even");
        }


    }
}
