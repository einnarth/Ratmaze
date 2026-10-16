package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class ImageEntity extends BaseEntity {
    protected Image image;

    public ImageEntity(Point2D position, String path) {
        super(position);
        this.image = new Image(getClass().getResourceAsStream(path));
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(image, position.getX(), position.getY());
    }

    @Override
    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), position.getY(), image.getWidth(), image.getHeight());
    }
}
