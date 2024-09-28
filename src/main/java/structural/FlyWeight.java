
package structural;

import java.util.*;

public class FlyWeight {
    public static void main(String[] args) {
        ShapeFW circle1 = ShapeFactory.getShape("CircleFW");
        circle1.draw();

        ShapeFW circle2 = ShapeFactory.getShape("CircleFW");
        circle2.draw();

        ShapeFW rectangle1 = ShapeFactory.getShape("Rectangle");
        rectangle1.draw();

        ShapeFW rectangle2 = ShapeFactory.getShape("Rectangle");
        rectangle2.draw();

        System.out.println(circle1 == circle2);
    }
}

abstract class ShapeFW {
    abstract void draw();
}

class CircleFW extends ShapeFW {
    void draw() {
        System.out.println("CircleFW drawn");
    }
}

class Rectangle extends ShapeFW {
    void draw() {
        System.out.println("Rectangle drawn");
    }
}

class ShapeFactory {
    private static final Map<String, ShapeFW> shapes = new HashMap<>();

    public static ShapeFW getShape(String shape) {
        ShapeFW s = shapes.get(shape);
        if (s == null) {
            switch (shape) {
                case "CircleFW":
                    s = new CircleFW();
                    break;
                case "Rectangle":
                    s = new Rectangle();
                    break;
            }
            shapes.put(shape, s);
        }
        return s;
    }
}