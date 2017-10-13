package edu.virginia.engine.display;

import edu.virginia.engine.util.GameClock;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatedSprite extends Sprite {

    /* The animation that is displayed by this object */
    private ArrayList<Animation> animations = new ArrayList<Animation>();

    /* The playing variable */
    private boolean playing = false;

    /* The filename variable */
    private String filename;

    /* The frame images*/
    private ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();

    /* The current image index */
    private int currentFrame;

    /* The first image index */
    private int startFrame;

    /* The end image index */
    private int endFrame;

    /* The frame images */
    private double DEFAULT_ANIMATION_SPEED = 90;

    /* The frame images */
    private double animationSpeed = DEFAULT_ANIMATION_SPEED;


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
    public double getAnimationSpeed(){ return animationSpeed; };

    public void setPlaying(boolean b){ playing = b; };
    public boolean isPlaying(){ return playing; };

    public int getCurrentFrame(){ return currentFrame; };

    /**
     * Draws this animation. This should be overloaded if a display object should
     * draw to the screen differently. This method is automatically invoked on
     * every frame.
     * */
    public void draw(Graphics g) {

        if (frames != null && frames.get(currentFrame) != null)
        if (playing && gameClock.getElapsedTime() >= animationSpeed) {
            setDisplayImage(frames.get(currentFrame));
            super.draw(g);
            if (currentFrame < endFrame)
                currentFrame++;
            else
                currentFrame = startFrame;
            gameClock.resetGameClock();
        }
        else {
            setDisplayImage(frames.get(currentFrame));
            super.draw(g);
        }
    }

    //Andy Partner 2
    //2.1
    public void initializeFrames(String[] images) {
        for(String s : images)
            frames.add(readImage(s));
    }

    //Partner 2.2
    public Animation getAnimation(String checkid) {
        for (Animation a : animations)
            if (a.getId().equals(checkid))
                return a;
        return null;
    }

    //Partner 2.3
    public void animate(Animation a) {
        this.startFrame = a.getStartFrame();
        this.endFrame = a.getEndFrame();
    }
    public void animate(String id) {
        Animation temp = getAnimation(id);
        this.startFrame = temp.getStartFrame();
        this.endFrame = temp.getEndFrame();
    }

    public void animate(int sf, int ef) {
        this.startFrame = sf;
        this.endFrame = ef;
    }

    //Partner 2.4 this doesnt work
    public void stopAnimation(int framenum) {
        //stops animation at this frame.
        if (currentFrame == framenum)
            playing = false;
    }
    public void stopAnimation() { // no parameter
        stopAnimation(startFrame);
    }
}

