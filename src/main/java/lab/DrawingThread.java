package lab;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DrawingThread extends AnimationTimer {

    private final Canvas canvas;
    private final GraphicsContext gc;

    private Level level;
    private long lastFrame = 0;


    public DrawingThread(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.level = new Level(canvas.getWidth(), canvas.getHeight());
    }

    /**
     * Draws objects into the canvas. Put you code here.
     */
    @Override
    public void handle(long now) {
        double delta = lastFrame == 0 ? 0 : (now - lastFrame) / 1_000_000_000D;
        lastFrame = now;
        level.draw(gc);
        level.simulate(delta);
    }

}
