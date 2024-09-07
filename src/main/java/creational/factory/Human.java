package creational.factory;

public class Human extends Animal {

    public Human() {

    }

    @Override
    public void eat() {
        System.out.println("Human eat cooked food");
    }
}
