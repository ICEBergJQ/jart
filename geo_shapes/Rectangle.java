package geo_shapes;

import java.awt.Color;

public class Rectangle implements Drawable {
    private Point p1, p2;
    private Color color;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = Point.randomColor();
    }

    @Override
    public void draw(Displayable displayable) {
        Point p3 = new Point(p1.getX(), p2.getY());
        Point p4 = new Point(p2.getX(), p1.getY());

        DrawUtils.drawLine(displayable, p1.getX(), p1.getY(), p3.getX(), p3.getY(), color);
        DrawUtils.drawLine(displayable, p3.getX(), p3.getY(), p2.getX(), p2.getY(), color);
        DrawUtils.drawLine(displayable, p2.getX(), p2.getY(), p4.getX(), p4.getY(), color);
        DrawUtils.drawLine(displayable, p4.getX(), p4.getY(), p1.getX(), p1.getY(), color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public static Rectangle random(int width, int height) {
        Point a = Point.random(width, height);
        Point b = Point.random(width, height);

        while (a.getX() == b.getX() && a.getY() == b.getY()) {
            b = Point.random(width, height);
        }

        return new Rectangle(a, b);
    }
}
