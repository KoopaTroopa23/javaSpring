package com.example.javaspring.learning;

public class ForLoop {

// Basic for loop   Numbers 1 to 10
    public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {   // this states that i = 1; to go up 9; increase by 1
        System.out.println(i);
    }

        System.out.println("BREAK 1");
//  initialization ; condition ;  increment
// they can be empty BUT you always need 2 semicolons;

int m = 5;
for ( ; m <= 10; m++) {
        System.out.println(m);
}
 
        System.out.println("BREAK 2");    
// 5 multiplication table
    for (int b = 5; b < 55; b+=5) {
        System.out.println(b);
    }

        System.out.println("BREAK 3");    
// quiz
    for (int c = 7; c < 64; c+=7) {
        System.out.println(c);
    }

        System.out.println("BREAK 4");
// even number

    for (int d = 2; d < 20; d += 2) {
        System.out.println(d);
    }

        System.out.println("BREAK 5");
    
    for (int f = 10; f > -30; f -= 10) {            // subtraction
        System.out.println(f);
    }

        System.out.println("BREAK 6");
    for (int h = 30; h < 91; h *= 3)  {            // multiplication
        System.out.println(h);
    }

        System.out.println("BREAK 7");

// multiple varibles  -  loop two variables at once: p goes 1->10, o goes 2->20, both increase by 1 each time

    for (int p = 1, o = 2; p <= 10 && o <= 20; p++, o++) {
        System.out.println(p + "" + o);
    }
       

    }
}
