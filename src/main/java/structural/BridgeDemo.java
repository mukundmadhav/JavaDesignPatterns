package structural;
public class BridgeDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape greenCircle = new Circle(new GreenColor());

        redCircle.draw();
        greenCircle.draw();
    }
}

// Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Implementor
interface Color {
    void fill();
}

// Refined Abstraction
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    void draw() {
        System.out.println("Circle drawn with color: ");
        color.fill();
    }
}

// Concrete Implementor
class RedColor implements Color {
    public void fill() {
        System.out.println("Red");
    }
}

class GreenColor implements Color {
    public void fill() {
        System.out.println("Green");
    }
}