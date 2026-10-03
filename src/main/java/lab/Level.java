package lab;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Level {

	private final double width;
	private final double height;

    private final List<GameEntity> entities;

	public Level(double width, double height) {
		this.width = width;
		this.height = height;
        this.entities = new ArrayList<>();

        entities.add(new Rat(new Point2D(50, 50), new Point2D(150, 100)));
        entities.add(new Cheese(new Point2D(200, 150)));
        entities.add(new Cheese(new Point2D(500, 300)));
        entities.add(new Cheese(new Point2D(650, 100)));
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.clearRect(0, 0, width, height);

        for (GameEntity entity : entities) {
            entity.draw(gc);
        }
	}

	public void simulate(double delay) {
        for (GameEntity entity : entities) {
            entity.simulate(delay);
        }
    }
}


