package com.example.javaspring.learning;

public class LogicalOperators {
    public static void main(String[] args) {
    /* 
    && (AND) — true only if both sides are true
    || (OR) — true if at least one side is true
    ! (NOT) — flips true to false, or false to true 
    */

    int age = 20;
    boolean hasID = true;

    System.out.println(age >= 18 && hasID);   // true only if BOTH are true
    System.out.println(age >= 18 || hasID);   // true if EITHER is true
    System.out.println(!hasID);               // flips hasID (true -> false)  ! only works for boolean values
    
    }


}
