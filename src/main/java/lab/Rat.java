package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Rat extends ImageEntity {
    private Point2D speed;
    private Point2D oldPosition;
    private static final Random RANDOM = new Random();

    public Rat(Point2D position, Point2D speed) {
        super(position, "rat.png");
        this.speed = speed;
    }

    @Override
    public void simulate(double delay) {
    }

    @Override
    public void collision() {
        if (oldPosition != null) {
            this.position = oldPosition;
        }
    }
    public void moveX(double dx) {
        this.position = this.position.add(dx, 0);
    }

    public void moveY(double dy) {
        this.position = this.position.add(0, dy);
    }

    public void savePosition() {
        this.oldPosition = this.position;
    }
}


