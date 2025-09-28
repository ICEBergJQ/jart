package geo_shapes;

import java.awt.Color;
// import java.util.Random;

public class Triangle implements Drawable {
    private Point p1, p2, p3;
    private Color color;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = Point.randomColor();
    }

    @Override
    public void draw(Displayable displayable) {
        drawLine(displayable, p1.getX(), p1.getY(), p2.getX(), p2.getY(), color);
        drawLine(displayable, p2.getX() , p2.getY(), p3.getX(), p3.getY(), color);
        drawLine(displayable, p3.getX(), p3.getY(), p1.getX(), p1.getY(), color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public static Triangle random(int width, int height) {
        Point a = Point.random(width, height);
        Point b = Point.random(width, height);
        Point c = Point.random(width, height);

        // ensure points are not all the same
        while ((a.getX() == b.getX() && a.getY() == b.getY()) || (b.getX() == c.getX() && b.getY() == c.getY()) || (c.getX() == a.getX() && c.getY() == a.getY())) {
            b = Point.random(width, height);
            c = Point.random(width, height);
        }

        return new Triangle(a, b, c);
    }

    public void drawLine(Displayable displayable,  int x1, int y1, int x2, int y2, Color color) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            displayable.display(Math.round(x), Math.round(y), color);
            x += xInc;
            y += yInc;
        }
    }
}
