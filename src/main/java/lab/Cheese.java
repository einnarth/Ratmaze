package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cheese extends BaseEntity {
    private static final double SIZE = 15;

    public Cheese(Point2D position) {
        super(position);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GOLD);
        gc.fillRect(position.getX(), position.getY(), SIZE, SIZE);
    }

    @Override
    public void simulate(double delay) {
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), SIZE, SIZE);
    }
}
