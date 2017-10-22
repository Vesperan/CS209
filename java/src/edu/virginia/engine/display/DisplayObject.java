package edu.virginia.engine.display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * A very basic display object for a java based gaming engine
 * 
 * */
public class DisplayObject {

	//Private reference to parent display object
	private DisplayObject parent;

	//All DisplayObject have a unique id
	private String id;

	//The image that is displayed by this object
	private BufferedImage displayImage;

	//The position variable
	private Point position = new Point(0,0);

	//The pivot point variable
	private Point pivotPoint = new Point(0,0);

	//The rotation amount in radians
	private double rotation = 0;

 	//Toggles if display object should be visible
	private Boolean visible = true;

	//Current value for measuring transparency of the object
	private float alpha = 1.0f;

	//Transparency of the object in the previous frame
	private float oldAlpha = 0.0f;

	//Scales the image along x-axis
	private double scaleX = 1.0;

	//Scales the image along y-axis
	private double scaleY = 1.0;

	/**
	 * Constructors: can pass in the id OR the id and image's file path and
	 * position OR the id and a buffered image and position
	 */
	public DisplayObject(String id) {
		this.setId(id);
	}

	public DisplayObject(String id, String fileName) {
		this.setId(id);
		this.setImage(fileName);
	}

	public DisplayObject(String id, String fileName, DisplayObject p, Point pos) {
        this.setId(id);
        this.setImage(fileName);
        parent=p;
        position=pos;
    }

    //Getters and Setters
	public DisplayObject getParent() {
		return parent;
	}
	public void setParent(DisplayObject p) {
		this.parent = p;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setPosition(Point pos) {
		position = pos;
	}
	public Point getPosition() {
		return position;
	}

	public void setPivotPoint(Point pp) {
		pivotPoint = pp;
	}
	public Point getPivotPoint() {
		return pivotPoint;
	}

	public void setRotation(double rotate) {
		rotation = rotate;
	}
	public double getRotation() {
		return rotation;
	}

    public void setVisible(Boolean vis) { this.visible = vis; }
    public Boolean getVisible() { return visible; }

    public void setAlpha(float a) { this.alpha = a; }
    public float getAlpha() { return alpha; }

    public void setOldAlpha(float oa) { this.oldAlpha = oa; }
    public float getOldAlpha() { return oldAlpha; }

    public void setScaleX(double sx) { scaleX = sx; }
    public double getScaleX() { return scaleX; }

    public void setScaleY(double sy) { scaleY = sy; }
 	public double getScaleY() { return scaleY; }

 	//Image-related methods
    public void setDisplayImage(BufferedImage di) { displayImage = di; }
    public BufferedImage getDisplayImage() {
        return this.displayImage;
    }

	protected void setImage(String imageName) {
		if (imageName == null) {
			return;
		}
		displayImage = readImage(imageName);
		if (displayImage == null) {
			System.err.println("[DisplayObject.setImage] ERROR: " + imageName + " does not exist!");
		}
	}

	/**
	 * Helper function that simply reads an image from the given image name
	 * (looks in resources\\) and returns the bufferedimage for that filename
	 * */
	public BufferedImage readImage(String imageName) {
		BufferedImage image = null;
		try {
			String file = ("resources" + File.separator + imageName);
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("[Error in DisplayObject.java:readImage] Could not read image " + imageName);
			e.printStackTrace();
		}
		return image;
	}

	public void setImage(BufferedImage image) {
		if(image == null) return;
		displayImage = image;
	}

    //Returns the unscaled width and height of this display object
    public int getUnscaledWidth() {
        if(displayImage == null) return 0;
        return displayImage.getWidth();
    }
    public int getUnscaledHeight() {
        if(displayImage == null) return 0;
        return displayImage.getHeight();
    }

    //Returns the scaled width and height of this display object
    public int getScaledWidth() {
        if(displayImage == null) return 0;
        return (int)(scaleX*displayImage.getWidth());
    }
    public int getScaledHeight() {
        if(displayImage == null) return 0;
        return (int)(scaleY*displayImage.getHeight());
    }

	/**
	 * Invoked on every frame before drawing. Used to update this display
	 * objects state before the draw occurs. Should be overridden if necessary
	 * to update objects appropriately.
	 * */
	protected void update(ArrayList<Integer> pressedKeys) { }

	/**
	 * Draws this image. This should be overloaded if a display object should
	 * draw to the screen differently. This method is automatically invoked on
	 * every frame.
	 * */
	public void draw(Graphics g) {

		if (displayImage != null && this.visible == true) {
			
			//Get the graphics and apply this objects transformations (rotation, etc.)
			Graphics2D g2d = (Graphics2D) g;
			//Commented out because planet transformations happen separately
			//applyTransformations(g2d);

            //Actually draw the image
			g2d.drawImage(displayImage, 0, 0,
					(int) (getUnscaledWidth()),
					(int) (getUnscaledHeight()), null);

			//undo the transformations so this doesn't affect other DisplayObjects
			//reverseTransformations(g2d);
		}
	}

	/**
	 * Applies transformations for this display object to the given graphics
	 * object
	 * */
	protected void applyTransformations(Graphics2D g2d) {
        g2d.translate(position.x, position.y);
        g2d.rotate(rotation, pivotPoint.x, pivotPoint.y);

        //Commented out because planets are scaled a special way
        //g2d.scale(scaleX, scaleY);

        float curAlpha;
        this.oldAlpha = curAlpha = ((AlphaComposite) g2d.getComposite()).getAlpha();
        g2d.setComposite(AlphaComposite.getInstance(3,curAlpha * this.alpha));
	}

	/**
	 * Reverses transformations for this display object to the given graphics
	 * object
	 * */
	protected void reverseTransformations(Graphics2D g2d) {
        g2d.rotate(-rotation, pivotPoint.x, pivotPoint.y);
        g2d.translate(-position.x, -position.y);
        g2d.setComposite(AlphaComposite.getInstance(3, this.oldAlpha));

	}

	//Debugging methods for coordinate systems
    public Point localToGlobal(Point p){
		return new Point(p.x + parent.position.x,p.y + parent.position.y);
	}
	public Point globalToLocal(Point p){
        return new Point(p.x - parent.position.x,p.y - parent.position.y);
    }

}
