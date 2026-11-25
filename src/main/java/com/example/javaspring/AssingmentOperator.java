package com.example.javaspring;

public class AssingmentOperator {
    public static void main(String[] args) {
    int i = 15;
    int k = 20;
    int j = k - i;
        System.out.println(j);

    int n = 10;
    n += 5;   // same as n = 10 + 5
        System.out.println(n);

    // int n now equals 15
    n -= 3;   // same as n = 15 - 3
        System.out.println(n);

    // int n now equals 12
    n *= 2;   // same as n = 12 * 2
        System.out.println(n);

    // int n now equals 24
    n /= 4;   // same as n = 24 / 4
        System.out.println(n);

    // int n now equals 6
    n %= 5;   // same as n = 6 % 5
        System.out.println(n);

    // int n now equals 1
    n++;      // increment by 1  (1 + 1)
        System.out.println(n);

    // int n now equals 2
    n--;      // decrement by 1 (1 - 2)
        System.out.println(n);




    int x = 5;
        System.out.println(x++); // prints 5, THEN increments (x becomes 6)
        System.out.println(x);   // prints 6

    int y = 5;
        System.out.println(++y); // increments FIRST (y becomes 6), THEN prints 6


    }
}
