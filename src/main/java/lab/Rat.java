package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Rat extends BaseEntity {
    private Point2D speed;
    private static final Random RANDOM = new Random();
    private final Image image;

    public Rat(Point2D position, Point2D speed) {
        super(position);
        this.speed = speed;
        this.image = new Image(getClass().getResourceAsStream("rat.png"));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
    }

    @Override
    public void simulate(double delay) {
        position = position.add(speed.multiply(delay));
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), image.getWidth(), image.getHeight());
    }

    @Override
    public void collision() {
        double rx = RANDOM.nextDouble(-100, 100);
        double ry = RANDOM.nextDouble(-100, 100);
        speed = new Point2D(-speed.getX() + rx, -speed.getY() + ry);

        this.position = this.position.add(speed.multiply(0.05));
    }
}


