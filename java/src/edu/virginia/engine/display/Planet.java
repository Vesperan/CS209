package edu.virginia.engine.display;

import java.util.ArrayList;
import java.awt.*;

//A class for planets, and also things like suns and asteroids and moons.
public class Planet extends Sprite {

    //The amount by which a Planet's orbit is adjusted every frame
    private double rotateSpeed = 0;

    //Whether or not the Planet has an elliptical orbit
    private boolean ellipse = false;

    //If the orbit is elliptical, orbitRadius is the rate at which the pivot is moved each frame
    private int orbitRadius = 0;

    //If the orbit is elliptical, orbitRadDir is the direction the pivot is moved.
    private int orbitRadDir = 1;

    public Planet(String id, String imageFileName, DisplayObject p, Point pos) {
        super(id, imageFileName);
        setParent(p);
        setPosition(pos);
    }

    //Getters and setters
    public double getRotateSpeed(){ return rotateSpeed; }
    public void setRotateSpeed(double d){ rotateSpeed = d; }

    public boolean isEllipse() {return ellipse; }
    public void setEllipse(boolean e) { ellipse = e; }

    public int getOrbitRadius(){ return orbitRadius; }
    public void setOrbitRadius(int d){ orbitRadius = d; }

    public int getOrbitRadDir(){ return orbitRadDir; }
    public void setOrbitRadDir(int d){ orbitRadDir = d; }

    @Override
    public void update(ArrayList<Integer> pressedKeys) {
        super.update(pressedKeys);
    }
}
