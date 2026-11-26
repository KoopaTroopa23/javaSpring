package com.example.javaspring.dessert;

public class DessertDemo {
    public static void main(String[] args) {
        
        Cake birthdayCake = new Cake("Chocolate", 8, Size.LARGE); // creates an Instance of Cake — "new" calls the constructor, which fills in flavor and slices

        System.out.println(birthdayCake.describe());  // calls Cake's describe() method and prints what it returns
        


// The class Cake is just a blueprint — it doesn't actually exist as a real thing until you make an instance.

// new Cake("Chocolate", 8) is you saying "make me an actual, real cake from that blueprint, with these specific details." Without doing that, you just have the idea of a cake, not an actual one you can use.



// Cake          -> from Class Cake 
// birthdayCake  -> the name you're giving this variable, so you can refer to it later
// =             -> assigns what's on the right into the variable on the left
// new           -> tells Java "create an actual object," triggers the constructor
// Cake(...)     -> calling Cake's constructor to build the object
// "Chocolate"   -> first argument, goes into the flavor parameter
// ,             -> separates the arguments
// 8             -> second argument, goes into the slices parameter
// ;             -> ends the statement
// describe is the name of the method you created. 
    }
}
