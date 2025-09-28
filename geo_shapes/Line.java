
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
		this.color = randomcolor();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Displayable displayable) {
		double x0 = p1.getX();
		double y0 = p1.getY();
		double x1 = p2.getX();
		double y1 = p2.getY();
		double dx = x1 - x0;
		double dy = y1 - y0;
		double step = Math.max(Math.abs(dx), Math.abs(dy));
		double x_incr = dx / step;
		double y_incr = dy / step;
		double x = x0;
		double y = y0;
		for (int i = 0; i <= (int)step; i++) {
			displayable.display((int)Math.round(x), (int)Math.round(y), color);
			x += x_incr;
			y += y_incr;
		}
	}
	@Override
	public Color getColor() {
		return color;
	}

	public static Line random(int width, int height) {
		Random rand = new Random();
		Point p1 = new Point(rand.nextInt(width), rand.nextInt(height));
		Point p2 = new Point(rand.nextInt(width), rand.nextInt(height));
		return new Line(p1, p2);
	}
    public Color randomcolor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }
}

