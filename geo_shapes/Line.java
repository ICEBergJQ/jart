
package geo_shapes;

import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
	private Point p1;
	private Point p2;
	private Color color;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = Point.randomColor();
    }

    public static Line random(int width, int height) {
        Random rand = new Random();
        Point p1 = new Point(rand.nextInt(width), rand.nextInt(height));
        Point p2 = new Point(rand.nextInt(width), rand.nextInt(height));
        return new Line(p1, p2);
    }

    @Override
    public void draw(Displayable displayable) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();

        DrawUtils.drawLine(displayable, x1, y1, x2, y2, color);
    }

    @Override
    public Color getColor() {
        return color;
    }
}

