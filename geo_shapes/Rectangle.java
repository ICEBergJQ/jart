package geo_shapes;

import java.awt.Color;
import java.util.Random;
public class Rectangle implements Drawable {
    private Point p1, p2;
    private Color color;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = randomcolor();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Displayable displayable) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        Line l1=new Line(new Point(x1, y1), new Point(x2, y1));
        Line l2=new Line(new Point(x2, y1), new Point(x2, y2));
        Line l3=new Line(new Point(x2, y2), new Point(x1, y2));
        Line l4=new Line(new Point(x1, y2), new Point(x1, y1));
        l1.setColor(this.color);
        l2.setColor(this.color);
        l3.setColor(this.color);
        l4.setColor(this.color);
        l1.draw(displayable);
        l2.draw(displayable);
        l3.draw(displayable);
        l4.draw(displayable);
    }

    @Override
    public Color getColor() {
        return color;
    }
    public Color randomcolor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }
}
