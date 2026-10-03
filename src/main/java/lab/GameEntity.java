package lab;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;



public interface GameEntity {
    void draw(GraphicsContext gc);
    void simulate(double delay);
    Rectangle2D getBoundingBox();
    void collision();
}
