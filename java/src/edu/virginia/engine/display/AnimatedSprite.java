package edu.virginia.engine.display;

import edu.virginia.engine.util.GameClock;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatedSprite extends Sprite {

    /* The animation that is displayed by this object */
    private ArrayList<Animation> animations;

    /* The playing variable */
    private boolean playing = false;

    /* The filename variable */
    private String filename;

    /* The frame images*/
    private ArrayList<BufferedImage> frames;

    /* The current image index */
    private int currentFrame;

    /* The first image index */
    private int startFrame;

    /* The end image index */
    private int endFrame;

    /* The frame images */
    private double DEFAULT_ANIMATION_SPEED = 10;

    /* The frame images */
    private double animationSpeed = DEFAULT_ANIMATION_SPEED;

    // frame counter
    private int frameCounter = 0;

    /* The gameclock */
    private GameClock gameClock = new GameClock();

    public AnimatedSprite(String id, String imageFileName, Point p)
    {
        super(id, imageFileName);
        setPosition(p);
    }

    public void initGameClock(){ gameClock = new GameClock(); };

    public void setAnimation(Animation an){ animations.add(an); };

    public void setAnimationSpeed(double as){ animationSpeed = as; };

    /**
     * Draws this animation. This should be overloaded if a display object should
     * draw to the screen differently. This method is automatically invoked on
     * every frame.
     * */
    public void draw(Graphics g) {

        if (frames != null && playing && frameCounter >= animationSpeed && frames.get(currentFrame) != null) {
            setDisplayImage(frames.get(currentFrame));
            super.draw(g);
            if (currentFrame < endFrame)
                currentFrame++;
            else
                currentFrame = startFrame;
            frameCounter = 0;
        }
        else {
            setDisplayImage(frames.get(startFrame));
            super.draw(g);
            frameCounter++;
        }
    }

    //Andy Partner 2
    //2.1
    public void initializeFrames(String image1, String image2, String image3) {
        frames.add(readImage(image1));
        frames.add(readImage(image2));
        frames.add(readImage(image3));

    }
    //initializeFrames("mario_walk_0.jpg");
    //initializeFrames("mario_walk_1.jpg");
    //initializeFrames("mario_walk_2.jpg"); ... and so forth if multiple images

    //Partner 2.2
    public Animation getAnimation(String checkid) {
        for (Animation name : animations)    //animations is a private arraylist in animatedSprite.java. Can't be accessed if getter is in Animation.java
            if (name.id.equals(checkid))    //Animation's id is a private variable in Animation.java ... can't be accessed if getter is in AnimatedSprite.java?
                return name;
        return new Animation("none", 0, 0); //What do I return if the one im searching for is not found? need to return some Animation?
    }

    //Partner 2.3
    public void animate(Animation a) {
        this.startFrame = a.getStartFrame();
        this.endFrame = a.getEndFrame();
    }
    public Animation animate(String id) {
        return getAnimation(id);
    }
    public void animate(int sf, int ef) {
        this.startFrame = sf;
        this.endFrame = ef;
    }

    //Partner 2.4 this doesnt work
    public void stopAnimation(int framenum) {//says to use code from inializeFrames() to extract image?
        //stops animation at this frame.
        if (currentFrame == framenum)
            frames = null;
            //super.stop(); //could also call stop() in Game.java which stops animation. DisplayObject -> Game,Sprite.  Sprite-> AnimatedSprite

    }
    public void stopAnimation() { // no parameter
        //stops animation at the startFrame
        if (this.currentFrame == startFrame)
            frames = null;
    }
}

