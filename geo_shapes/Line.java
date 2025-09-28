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
        this.color = randomColor();
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

    @Override
    public Color getColor() {
        return color;
    }

    public static Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
