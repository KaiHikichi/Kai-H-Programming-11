package sample;

import javafx.scene.shape.Rectangle;


public class Box {
    public String id;
    public Rectangle square;
    public int state;

    public Box(String id, Rectangle square){
        this.id = id;
        this.square = square;
    }

    @Override
    public String toString() {
        return this.state + "";
    }
}
