import java.util.ArrayList;
import java.util.List;

interface FractalComponent {
    void draw();
    void addComponent(FractalComponent component);
    void removeComponent(FractalComponent component);
}

class Point implements FractalComponent {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("Drawing point at (" + x + ", " + y + ")");
    }

    @Override
    public void addComponent(FractalComponent component) {
        
    }

    @Override
    public void removeComponent(FractalComponent component) {
        
    }
}

class FractalShape implements FractalComponent {
    private List<FractalComponent> components = new ArrayList<>();

    @Override
    public void draw() {
        System.out.println("Drawing fractal shape:");
        for (FractalComponent component : components) {
            component.draw();
        }
    }

    @Override
    public void addComponent(FractalComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(FractalComponent component) {
        components.remove(component);
    }
}

public class FractalArtGenerator {
    public static void main(String[] args) {
        FractalComponent sierpinskiTriangle = createSierpinskiTriangle(3);
        sierpinskiTriangle.draw();
    }

    private static FractalComponent createSierpinskiTriangle(int depth) {
        if (depth == 0) {
            return new Point(0, 0);
        }

        FractalShape triangle = new FractalShape();
        FractalComponent topTriangle = createSierpinskiTriangle(depth - 1);
        FractalComponent leftTriangle = createSierpinskiTriangle(depth - 1);
        FractalComponent rightTriangle = createSierpinskiTriangle(depth - 1);

        triangle.addComponent(topTriangle);
        triangle.addComponent(leftTriangle);
        triangle.addComponent(rightTriangle);

        return triangle;
    }
}