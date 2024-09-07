package creational;

import creational.factory.Animal;
import creational.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        singleTonTest();
        protoTypeTest();
        factoryTest();
        builderTest();
    }

    private static void builderTest() {
        System.out.println("\n\nTesting Builder Pattern...");
        BuilderEmployee employee = new BuilderEmployee.Builder()
                .setName("John")
                .setSurname("Doe")
                .setAge(30)
                .setGender("Male")
                .build();

        System.out.println(employee);
    }

    private static void factoryTest() {
        System.out.println("\n\nTesting Factory Pattern...");
        Animal cow = AnimalFactory.getAnimal("cow");
        cow.eat(); // Output: Cow eats grass

        Animal human = AnimalFactory.getAnimal("human");
        human.eat(); // Output: Human eats food

        try {
            Animal unknown = AnimalFactory.getAnimal("dog");
            unknown.eat();
        } catch (Exception e) {
            System.out.println(e.getMessage());  // Output: Unknown animal type: dog
        }
    }

    private static void singleTonTest() {
        System.out.println("\n\nTesting Singleton Pattern...");
        Thread thread1 = new Thread(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Thread 1: " + instance1);
        });

        Thread thread2 = new Thread(() -> {
            Singleton instance2 = Singleton.getInstance();
            System.out.println("Thread 2: " + instance2);
        });

        Thread thread3 = new Thread(() -> {
            Singleton instance3 = Singleton.getInstance();
            System.out.println("Thread 3: " + instance3);
        });

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void protoTypeTest() {
        System.out.println("\n\nTesting Prototype Pattern...");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Swimming");

        ProtoType original = new ProtoType("John", 25, hobbies);
        System.out.println("Original: " + original);

        // Clone the original object
        ProtoType cloned = (ProtoType) original.clone();
        System.out.println("Cloned: " + cloned);

        // Modify the cloned object's hobbies list to see if it affects the original
        cloned.hobbies.add("Cycling");

        System.out.println("\nAfter modifying the cloned object's hobbies:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // Check if both objects are different instances
        System.out.println("\nAre original and clone the same object? " + (original == cloned));
        System.out.println("Are original and clone's hobbies list the same object? " + (original.hobbies == cloned.hobbies));
    }
}
