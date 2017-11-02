package edu.virginia.engine.display;

import java.awt.*;

public class Hitbox extends Sprite {

    private double boxWidth;
    private double boxHeight;

    public Hitbox(DisplayObject p, Point pos, double x, double y, String filename) {
        super(p.getId()+" hitbox", filename);
        setParent(p);
        setPosition(pos);
        boxWidth = x;
        boxHeight = y;
        setVisible(false);
    }

    public double getBoxWidth() {
        return boxWidth;
    }
    public double getBoxHeight() {
        return boxHeight;
    }
    public void setBoxWidth(double x) {
        this.boxWidth = x;
    }
    public void setBoxHeight(double y) {
        this.boxHeight = y;
    }
}