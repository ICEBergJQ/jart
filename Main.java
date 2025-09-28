import geo_shapes.*;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 5; i++) {
            Point point = Point.random(image.getWidth(), image.getHeight());
            point.draw(image);
            // Circle circle = Circle.random(image.getWidth(), image.getHeight());
            // circle.draw(image);
        }

         for (int i = 0; i < 5; i++) {
            // Point point = Point.random(image.getWidth(), image.getHeight());
            // point.draw(image);
            // Circle circle = Circle.random(image.getWidth(), image.getHeight());
            // circle.draw(image);
            Line line = Line.random(image.getWidth(), image.getHeight());
            line.draw(image);
        }
        
        image.save("image.png");
    }
}
