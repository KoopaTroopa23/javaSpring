package com.example.javaspring.dessert;

public abstract class Dessert implements Bakeable {
    protected String flavor;

    public Dessert(String flavor) {
        this.flavor = flavor;
    }

    public abstract String bake();


    /*
    What is an abstract class? A class that can't be made into an object directly — it only exists to be extended by other classes (like Cake).

    Why make this? So Cake can all share the same flavor field and the same rule (must have bake()), without copy-pasting that into every single dessert class.
    
    Why protected instead of private? private would mean only Dessert itself can touch flavor — not even Cake, even though Cake extends it. protected says "subclasses can access this too," which you need here since Cake is built on top of Dessert.
    
    public abstract String bake(); — this is NOT a working method. It's a placeholder that says "every class that extends Dessert MUST write its own bake() method that returns a String." No { }, no code inside — Dessert itself doesn't decide how baking works; it forces Cake to decide that.
     */
}