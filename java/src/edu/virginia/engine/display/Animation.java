package edu.virginia.engine.display;


public class Animation {
    /* All Animations have a unique id */
    private String id;

    /* The image that is displayed by this object */
    private int startFrame;

    /* The position variable */
    private int endFrame;

    public Animation(String idstr, int sf, int ef) {
        id = idstr;
        startFrame = sf;
        endFrame = ef;
    }

    public void setId(String idstr) {
        id = idstr;
    }

    public String getId() {
        return id;
    }

    public void setStartFrame(int sf) {
        startFrame = sf;
    }

    public int getStartFrame() {
        return startFrame;
    }

    public void setEndFrame(int ef) {
        endFrame = ef;
    }

    public int getEndFrame() {
        return endFrame;
    }

    //Partner 2.2
    public Animation getAnimation(String checkid) {
        for (Animation name : animations)    //not sure how to access animations arraylist since it's privately declared in AnimatedSprite.java.
            if (name.id.equals(checkid))    //should this getter be moved to AnimatedSprite.java file?
                return name;
        return new Animation("none", 0, 0); //What do I return if the one im searching for is not found? need to return some Animation.
    }

    //Partner 2.4
    public void stopAnimation(int framenum) {
        //stops animation at this frame

    }
    public void stopAnimation() { // no parameter
        //stops animation at the startFrame
    }
}
