package com.example.javaspring.dessert;

public class Cake extends Dessert {

    private int slices;
    private Size size;

    public Cake(String flavor, int slices, Size size) {
        super(flavor);
        this.slices = slices;
        this.size = size;
    }

    @Override
    public String bake() {
        return "Baking a " + flavor + " cake...";
    }

    public String describe() {
        return flavor + " cake, " + slices + " slices";
    }

    /*
    extends Dessert — this IS inheritance: Cake now gets flavor and the bake() requirement from Dessert, instead of redefining them itself
    private String flavor; removed — Cake no longer needs its own copy; it already has flavor from Dessert
    super(flavor) — calls Dessert's constructor to actually set flavor, since Cake doesn't own that field anymore
    @Override public String bake() — this is Cake finally writing the real code for the method Dessert left blank. Required, or this won't compile.
     */
}
