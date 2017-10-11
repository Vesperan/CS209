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


}
