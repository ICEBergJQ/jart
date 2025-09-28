package geo_shapes;

import java.awt.Color;

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
        DrawUtils.drawLine(displayable, p1.getX(), p1.getY(), p2.getX(), p2.getY(), color);
        DrawUtils.drawLine(displayable, p2.getX() , p2.getY(), p3.getX(), p3.getY(), color);
        DrawUtils.drawLine(displayable, p3.getX(), p3.getY(), p1.getX(), p1.getY(), color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public static Triangle random(int width, int height) {
        Point a = Point.random(width, height);
        Point b = Point.random(width, height);
        Point c = Point.random(width, height);

        while ((a.getX() == b.getX() && a.getY() == b.getY()) || (b.getX() == c.getX() && b.getY() == c.getY()) || (c.getX() == a.getX() && c.getY() == a.getY())) {
            b = Point.random(width, height);
            c = Point.random(width, height);
        }

        return new Triangle(a, b, c);
    }
}
