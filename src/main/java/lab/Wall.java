package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends BaseEntity {
    private final double width;
    private final double height;

    public Wall(Point2D position, double width, double height) {
        super(position);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.DARKRED);
        gc.fillRect(position.getX(), position.getY(), width, height);
    }

    @Override
    public void simulate(double delay) {
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), width, height);
    }

    @Override
    public void collision(){

    }
}
