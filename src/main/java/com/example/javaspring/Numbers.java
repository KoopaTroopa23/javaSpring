package com.example.javaspring;

import org.aspectj.weaver.loadtime.definition.Definition.DeclareAnnotation;

public class Numbers {
    public static void main(String[] args) {
        System.out.println(5 + 2);  // addition                
        System.out.println(5 - 8); // subtraction             
        System.out.println(5 * 3);  // multiplication
        System.out.println(5 / 10); // division
        System.out.println(5 % 10); // modulus
        System.out.println(5 * 5 / 13); // multiplication and division modulus come before addition and subtraction
        System.out.println(5.0 / 2.5); // this is a double division, not an integer division
        System.out.println((5 - 2) * 3); // brackets are used to change the order of operations

       
        // How many seconds in a day
        System.out.println("Seconds in a day: " +24 * 60 * 60);
               // string concatenation is done with the + operator

// Escape characters

        System.out.println("hello \n world");
        System.out.println("hello \t world");
        System.out.println("hello \\ world");

// Math.random ()

        System.out.println(Math.random());
        System.out.println(Math.min(23, 45));
        System.out.println(Math.max(5 , 4));

// int

        int i = 5;
        int j = 12;
        int k = 1; int a = 4;
        System.out.println(i + "" + j + "" + k + "" + a);   // prints each like a string
        System.out.println(i + j + k + a);                  // adds all the integers

// printf        %d and %n are Placeholders

        System.out.printf("5 * 2 = %d%n", 5 * 2);     // not to hardcode answer use printf
        System.out.printf("3 * 5 = %d%n", 3 * 5);     // %d a placeholder for an integer value
                                                      // %n not a placeholder at all. It inserts a new line
        System.out.printf("Print %s", "Test");     //  %s a placeholder for a string

        

               // Takeways
     
               // These are all expressions 
               // operators are * - + / %
               // operadnds are the 5 10 2 8 3
               // brackets ()
               // (parameter: argument,  parameter: argument)   a lot of developers confuse parameters and arguments
               // 3.0 (floating point number) 3 (integer) 3.0f (float) 3.0d (double)
               // println is method
               // Declaration  int j
        
               
    





    }
}
