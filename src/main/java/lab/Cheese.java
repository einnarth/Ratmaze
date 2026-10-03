package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class Cheese extends BaseEntity {
    private static final double SIZE = 15;
    private static final Random RANDOM = new Random();
    private final Image image;

    public Cheese(Point2D position) {
        super(position);
        this.image = new Image(getClass().getResourceAsStream("cheese.png"));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
    }

    @Override
    public void simulate(double delay) {
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), image.getWidth(), image.getHeight());
    }

    @Override
    public void collision() {
        double x = RANDOM.nextDouble(0, 700);
        double y = RANDOM.nextDouble(0, 350);
        this.position = new Point2D(x, y);
    }
}
