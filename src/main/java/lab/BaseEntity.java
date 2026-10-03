package lab;


import javafx.geometry.Point2D;

public abstract class BaseEntity implements GameEntity {
    protected Point2D position;

    public BaseEntity(Point2D position) {
        this.position = position;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

}
