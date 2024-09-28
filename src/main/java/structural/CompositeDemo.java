package structural;
import java.util.ArrayList;
import java.util.List;

// Component
interface Graphic {
    void draw();
}

// Leaf
class CircleC implements Graphic {
    public void draw() {
        System.out.println("Draw CircleC");
    }
}

// Composite
class GraphicComposite implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void addGraphic(Graphic graphic) {
        graphics.add(graphic);
    }

    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Client
public class CompositeDemo {
    public static void main(String[] args) {
        CircleC circle1 = new CircleC();
        CircleC circle2 = new CircleC();

        GraphicComposite graphicComposite = new GraphicComposite();
        graphicComposite.addGraphic(circle1);
        graphicComposite.addGraphic(circle2);

        graphicComposite.draw();
    }
}