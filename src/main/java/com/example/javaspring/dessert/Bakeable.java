package com.example.javaspring.dessert;

public interface Bakeable {
    String bake();

 //   This is a rule, not actual working code. It says: "any class that implements Bakeable must have a bake() method that returns a String." It doesn't say how bake() works — just that it must exist.

 // Think of it as a checklist a class has to follow, not code that runs by itself.
}
