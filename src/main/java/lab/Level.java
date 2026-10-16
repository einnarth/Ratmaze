package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {

	private final double width;
	private final double height;
    private int score = 0;

    private final List<GameEntity> entities;
    private final Rat player;
    private final Cheese[] cheeses;
    private static final double WALL_SIZE = 15;
    private static final Random RANDOM = new Random();

	public Level(double width, double height) {
		this.width = width;
		this.height = height;
        this.entities = new ArrayList<>();

        player = new Rat(new Point2D(50, 50), new Point2D(150, 100));
        entities.add(player);
        Wall topWall = new Wall(new Point2D(0, 0), width, WALL_SIZE);
        Wall bottomWall = new Wall(new Point2D(0, height - WALL_SIZE), width, WALL_SIZE);
        Wall leftWall = new Wall(new Point2D(0, 0), WALL_SIZE, height);
        Wall rightWall = new Wall(new Point2D(width - WALL_SIZE, 0), WALL_SIZE, height);
        entities.add(topWall);
        entities.add(bottomWall);
        entities.add(leftWall);
        entities.add(rightWall);
        cheeses = new Cheese[5];
        for (int i = 0; i < cheeses.length; i++) {
            Point2D randomPos = new Point2D(
                RANDOM.nextDouble(WALL_SIZE, width - WALL_SIZE - 20),
                RANDOM.nextDouble(WALL_SIZE, height - WALL_SIZE - 20)
            );
            cheeses[i] = new Cheese(randomPos);
            entities.add(cheeses[i]);
        }
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.LIGHTGREEN);
		gc.clearRect(0, 0, width, height);

        for (GameEntity entity : entities) {
            entity.draw(gc);
        }
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 24));
        gc.fillText("Score: " + score, width - 120, 40);
	}

	public void simulate(double delay) {
        for (GameEntity entity : entities) {
            entity.simulate(delay);
        }
        for (GameEntity entity : entities) {
            if (entity != player) {
                if (player.getBoundingBox().intersects(entity.getBoundingBox())) {
                    if (entity instanceof Cheese) {
                        Cheese cheese = (Cheese) entity;
                        cheese.collision();
                        score++;
                    }
                    else if (entity instanceof Wall) {
                        player.collision();
                    }

                }
            }
        }
    }
}



