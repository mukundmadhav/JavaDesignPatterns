package creational.factory;

import java.util.Locale;

public class AnimalFactory {

    public static Animal getAnimal(String animalType) {
        return switch (animalType.toLowerCase()) {
            case "cow" -> new Cow();
            case "human" -> new Human();
            default -> null;
        };
    }
}
