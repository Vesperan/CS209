package edu.virginia.engine.display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class DisplayObjectContainer extends DisplayObject {


    //ArrayList of DisplayObjects connected to the coordinate system of this object
    private ArrayList<DisplayObject> children = new ArrayList<DisplayObject>();

    //Constructors
    public DisplayObjectContainer(String id) {
        super(id);
    }
    public DisplayObjectContainer(String id, String fileName)  { super(id, fileName); }

    //Methods for dealing with children
    public void addChild(DisplayObject c) {
        children.add(c);
    }
    public void addChildAtIndex(DisplayObject c, int i) {
        children.add(i, c);
    }
    public void removeChild(DisplayObject c) {
        for (DisplayObject dobj : children)
            if (dobj.equals(c))
                children.remove(c);
    }
    public void removeByIndex(int i) {
        children.remove(i);
    }
    public void removeAll() {
        for (DisplayObject dobj : children)
            children.remove(dobj);
    }
    public Boolean containsDO(DisplayObject o) {
        for (DisplayObject dobj : children)
            if (dobj.equals(o))
                return true;
        return false;
    }
    public DisplayObject getChildById(String id) {
        for (DisplayObject dobj : children)
            if (dobj.getId().equals(id))
                return dobj;
        return null;
    }
    public DisplayObject getChildByIndex(int i) {
        return children.get(i);
    }

    //Method for returning all children
    public ArrayList<DisplayObject> getChildren() {
        return children;
    }

    //Method to draw the image of this container (if it exists) and also all associated children
    //Transformations of parent are applied to children
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(getVisible())
            applyTransformations(g2d);
            super.draw(g);
        if (children != null) {
            for (DisplayObject child : children) {
                child.draw(g2d);
            }
            reverseTransformations(g2d);
        }
    }
}
