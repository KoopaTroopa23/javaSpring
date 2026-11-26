package com.example.javaspring.dessert;

public class Cake {
    

    private String flavor;  // private = Access Modifier — only code inside Cake itself can touch these directly
    private int slices;     // flavor and slices = Fields — the data each Cake instance holds

    public Cake(String flavor, int slices) {   // Constructor — runs once, when you make a new Cake with "new Cake(...)"
        this.flavor = flavor;                  // "this.flavor" = the field; "flavor" = the parameter just passed in; this line copies the parameter INTO the field
        this.slices = slices;                  // same idea — stores the slices parameter into this object's own slices field
    }

}
