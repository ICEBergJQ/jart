package geo_shapes;

import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    private int x;
    private int y;
    private Color color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = randomColor();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Displayable displayable) {
        displayable.display(x, y, color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public static Point random(int width, int height) {
        Random rand = new Random();
       return new Point(rand.nextInt(width), rand.nextInt(height));
    }

    public static Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
