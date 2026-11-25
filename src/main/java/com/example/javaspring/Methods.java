package com.example.javaspring;

public class Methods {
    public static void main(String[] args) {
        System.out.println("-- sayHelloWorldTwice --");     // adding this println for clarity as to which method is printing. 
        sayHelloWorldTwice();

        System.out.println("-- sayGoodbye --");
        sayGoodbye();

        System.out.println("-- sayHelloWorldTen --");
        sayHelloWorldTen(10);                       // arguements

        System.out.println("-- printNumbers --");
        printNumbers(10);                       // arguements

        System.out.println("-- addTwoNumbers --");
        System.out.println(addTwoNumbers(10, 20));   // arguements
        
        System.out.println("-- Method Overloading 1 --");    
        System.out.println(add(1, 2, 5)); 

        System.out.println("-- Method Overloading 2 --");    
        System.out.println(add(1, 2)); 

        System.out.println("-- Word and Number --");    
        System.out.println(wordAndNumber("Kevin", 3, 4)); 
    
    }

    public static void sayHelloWorldTwice() {            // must be camelCase
            System.out.println("Hello World");
            System.out.println("Hello World");
        }

    public static void sayGoodbye() {
            System.out.println("Goodbye");
        }



    public static void sayHelloWorldTen(int noOfTimes) {   // parameter
        for (int i = 0; i < noOfTimes; i++) {                     // for (initialization; condition; update)  
            System.out.println("Hello World");                  // for (int i = 0; i < 10; i++) {   // this states that i = 0; to go up 9; increase by 1
        }
    }

    public static void printNumbers(int noOfNumbers) {   // parameter
        for (int a = 1; a < noOfNumbers; a+=1) {                     // for (initialization; condition; update)
            System.out.println(a);
        }
    }    

    public static int addTwoNumbers(int a, int b) {             // Java required a return when using public static int
        return a + b;                                               //  return hands a value back out of the method to whoever called it — like the method's answer.
        }
        
    public static int add (int a, int b, int c) {          // Method overloading part 1
        return a + b + c;
        }

    public static int add (int a, int b) {                  // Method overloading part 2
        return a + b;
    }

    public static String  wordAndNumber(String name, int a, int b) {
        return "Hi there " + name + " " + add(a,b);
    }

}


// javac src/main/java/com/example/javaspring/Methods.java -d build/classes/java/main
// java -cp build/classes/java/main com.example.javaspring.Methods
