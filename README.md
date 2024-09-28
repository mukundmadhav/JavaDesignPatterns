# Java Design Patterns Demo

This project demonstrates the implementation of several design patterns in Java. The patterns included are:

- **Singleton Pattern**
- **Prototype Pattern**
- **Factory Pattern**
- **Builder Pattern**

## Project Structure

The project consists of the following main classes:

- `MainClass.java`: Contains tests for each design pattern.
- `Singleton.java`: Implementation of the Singleton Pattern.
- `ProtoType.java`: Implementation of the Prototype Pattern.
- `Animal.java`, `AnimalFactory.java`: Implementation of the Factory Pattern.
- `BuilderEmployee.java`: Implementation of the Builder Pattern.

## Design Patterns

### Singleton Pattern

Ensures a class has only one instance and provides a global point of access to it. The Singleton class in this project is thread-safe.

**Key Class:** `Singleton`

**Usage Example:**

```java
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
```
