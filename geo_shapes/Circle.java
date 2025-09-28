package geo_shapes;

import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    public Point center;
    public int radius;
    public Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = Point.randomColor();
    }

    public static Circle random(int width, int height) {
        Random rand = new Random();
        Point center = new Point(rand.nextInt(width), rand.nextInt(height));
        int radius = rand.nextInt(191) + 10;
        return new Circle(center, radius);
    }

    @Override
    public void draw(Displayable displayable) {
        int steps = 180 * radius;
        Color color = this.color;

        for (int i = 0; i < steps; i++) {
            double theta = ((double) i * Math.PI) / steps;

            double x = center.getX() + radius * Math.cos(theta);
            double y = center.getY() + radius * Math.sin(theta);
            double minusY = center.getY() - radius * Math.sin(theta);

            displayable.display((int) Math.round(x), (int) Math.round(y), color);
            displayable.display((int) Math.round(x), (int) Math.round(minusY), color);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
