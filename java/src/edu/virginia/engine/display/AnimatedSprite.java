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
    private double DEFAULT_ANIMATION_SPEED = 1;

    /* The gameclock */
    private GameClock gameClock = new GameClock();

    public AnimatedSprite(String id, String imageFileName, Point p)
    {
        super(id, imageFileName);
        setPosition(p);
    }

    public void initGameClock(){ gameClock = new GameClock(); };
}
