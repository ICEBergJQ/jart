package geo_shapes;

import java.awt.Color;

public class Point implements Drawable {
    private int x;
    private int y;
    private Color color;

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.WHITE; // default color, can be changed
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Optionally let us change the color
    public void setColor(Color color) {
        this.color = color;
    }

    // --- Drawable implementation ---
    @Override
    public void draw(Displayable displayable) {
        displayable.display(x, y, color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    // For debugging
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
