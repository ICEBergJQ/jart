package geo_shapes;

import java.awt.Color;

public class DrawUtils {
    public static void drawLine(Displayable displayable, int x1, int y1, int x2, int y2, Color color) {
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
