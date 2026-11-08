package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Level {

	private final double width;
	private final double height;
    private int score = 0;

    private final List<GameEntity> entities = new ArrayList<>();
    private final Rat player;

    private static final double WALL_SIZE = 15;
    private static final Random RANDOM = new Random();

    private ScoreListener scoreListener;
    private final Comparator<GameEntity> comparator;

	public Level(double width, double height) {
		this.width = width;
		this.height = height;

        comparator = new Comparator<GameEntity>() {
            @Override
            public int compare(GameEntity o1, GameEntity o2) {
                if (o1 == o2){
                    return 0;
                }
                boolean o1IsWall = o1 instanceof Wall;
                boolean o2IsWall = o2 instanceof Wall;
                if (o1IsWall && !o2IsWall){
                    return -1;
                }
                if (!o1IsWall && o2IsWall){
                    return 1;
                }

                boolean o1IsCheese = o1 instanceof Cheese;
                boolean o2IsCheese = o2 instanceof Cheese;
                if (o1IsCheese && !o2IsCheese) return -1;
                if (!o1IsCheese && o2IsCheese) return 1;

                boolean o1IsRat = o1 instanceof Rat;
                boolean o2IsRat = o2 instanceof Rat;
                if (o1IsRat && !o2IsRat){
                    return 1;
                }
                if (!o1IsRat && o2IsRat){
                    return -1;
                }
                return 0;
            }
        };

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

        for (int i = 0; i < 5; i++) {
            Point2D randomPos = new Point2D(
                RANDOM.nextDouble(WALL_SIZE, width - WALL_SIZE - 20),
                RANDOM.nextDouble(WALL_SIZE, height - WALL_SIZE - 20)
            );
            entities.add(new Cheese(randomPos));
        }
        entities.sort(comparator);
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.LIGHTGREEN);
		gc.clearRect(0, 0, width, height);

        for (GameEntity entity : entities) {
            entity.draw(gc);
        }
	}

	public void simulate(double delay) {
        player.savePosition();
        double speed = 150 * delay;

        if (lab.App.activeKeys.contains(javafx.scene.input.KeyCode.W)) {
            player.moveY(-speed);
        }
        if (lab.App.activeKeys.contains(javafx.scene.input.KeyCode.S)) {
            player.moveY(speed);
        }
        if (lab.App.activeKeys.contains(javafx.scene.input.KeyCode.A)) {
            player.moveX(-speed);
        }
        if (lab.App.activeKeys.contains(javafx.scene.input.KeyCode.D)) {
            player.moveX(speed);
        }
        for (GameEntity entity : entities) {
            entity.simulate(delay);
        }
        for (GameEntity entity : entities) {
            if (entity != player) {
                if (player.getBoundingBox().intersects(entity.getBoundingBox())) {
                    if (entity instanceof Cheese cheese) {
                        cheese.collision();
                        score++;

                        if (scoreListener != null) {
                            scoreListener.onScoreChange(score);
                        }
                    }
                    else if (entity instanceof Wall) {
                        player.collision();
                    }

                }
            }
        }
        entities.sort(comparator);
    }
    public void setScoreListener(ScoreListener scoreListener) {
        this.scoreListener = scoreListener;
    }
}



