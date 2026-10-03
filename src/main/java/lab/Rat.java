package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rat extends BaseEntity {
    private Point2D speed;
    private static final double SIZE = 30;

    public Rat(Point2D position, Point2D speed) {
        super(position);
        this.speed = speed;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.fillOval(position.getX(), position.getY(), SIZE, SIZE);
    }

    @Override
    public void simulate(double delay) {
        position = position.add(speed.multiply(delay));
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), SIZE, SIZE);
    }
}


