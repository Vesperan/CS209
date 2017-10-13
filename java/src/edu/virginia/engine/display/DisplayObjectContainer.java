package edu.virginia.engine.display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class DisplayObjectContainer extends DisplayObject {

    private ArrayList<DisplayObject> children = new ArrayList<DisplayObject>();
    //private List<DisplayObject> children = new List<DisplayObject>();

    //constructor
    public DisplayObjectContainer(String id) {
        super(id);
    }

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

    public ArrayList<DisplayObject> getChildren() {
        return children;
    }

    @Override
    protected void draw(Graphics g) {
        if (children != null && this.getVisible() == true) {
            super.draw(g);
            applyTransformations(g);

            for (DisplayObject child : children) {
                child.draw(g);
            }

            reverseTransformations(g);
        }

    }

    @Override
    protected void update(ArrayList<Integer> pressedKeys) {

    }
}
