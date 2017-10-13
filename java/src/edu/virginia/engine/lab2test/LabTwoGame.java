package edu.virginia.engine.lab2test;

import edu.virginia.engine.display.Animation;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.display.AnimatedSprite;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabTwoGame extends Game{

    int framevcounter= 0;
	/* Create a sprite object for our game. We'll use mario */
	AnimatedSprite mario = new AnimatedSprite("Mario", "mario_walk_0.png", new Point(50,50));

	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabTwoGame() {
		super("Lab One Test Game", 500, 650);
	}
	
	/**
	 * Engine will automatically call this update method once per frame and pass to us
	 * the set of keys (as strings) that are currently being pressed down
	 * */
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);

		framevcounter++;

		if(pressedKeys.contains(VK_O)){ mario.setAnimationSpeed(mario.getAnimationSpeed() + 5);
		System.out.println(mario.getAnimationSpeed());
		}
		if(pressedKeys.contains(VK_P)){ mario.setAnimationSpeed(mario.getAnimationSpeed() - 5);  }
        if(pressedKeys.contains(VK_Y)) {
                mario.stopAnimation(mario.getCurrentFrame());
        }
		if(pressedKeys.contains(VK_T)) {
                mario.setPlaying(true);
        }
		if(pressedKeys.contains(VK_R)){ mario.stopAnimation(); }

        if(pressedKeys.contains(VK_L)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x+5,
                (int) mario.getPivotPoint().y)); }
        if(pressedKeys.contains(VK_J)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x-5,
                (int) mario.getPivotPoint().y)); }
        if(pressedKeys.contains(VK_I)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x,
                (int) mario.getPivotPoint().y-5)); }
        if(pressedKeys.contains(VK_K)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x,
                (int) mario.getPivotPoint().y+5)); }

        if(pressedKeys.contains(VK_RIGHT)){ mario.setPosition(new Point((int) mario.getPosition().x+5,
                (int) mario.getPosition().y));
				mario.setPlaying(true); }
        if(pressedKeys.contains(VK_LEFT)){ mario.setPosition(new Point((int) mario.getPosition().x-5,
                (int) mario.getPosition().y)); }
        if(pressedKeys.contains(VK_UP)){ mario.setPosition(new Point((int) mario.getPosition().x,
                (int) mario.getPosition().y-5)); }
        if(pressedKeys.contains(VK_DOWN)){ mario.setPosition(new Point((int) mario.getPosition().x,
                (int) mario.getPosition().y+5)); }

        if(pressedKeys.contains(VK_W)){ mario.setRotation(mario.getRotation()+(Math.PI/50)); }
        if(pressedKeys.contains(VK_Q)){ mario.setRotation(mario.getRotation()-(Math.PI/50)); }

		if(pressedKeys.contains(VK_V) && framevcounter > 10)
		{
		    mario.setVisible(mario.getVisible()^true);
		    framevcounter = 0;
		}

        if(pressedKeys.contains(VK_Z))
        {
            if(mario.getAlpha() + (float).1 < 1)
                mario.setAlpha(mario.getAlpha() + (float).1);
            else
                mario.setAlpha((float) 1);
        }

        if(pressedKeys.contains(VK_X))
        {
            if(mario.getAlpha()>0.1)
                mario.setAlpha(mario.getAlpha() - (float).1);
            else
                mario.setAlpha((float) 0);
        }

        if(pressedKeys.contains(VK_A)) {
            mario.setScaleY(mario.getScaleY() + .1);
            mario.setScaleX(mario.getScaleX() + .1);
        }

        if(pressedKeys.contains(VK_S)) {
            mario.setScaleX(mario.getScaleX() - .1);
            mario.setScaleY(mario.getScaleY() - .1);
        }

		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		if(mario != null) mario.update(pressedKeys);


	}
	
	/**
	 * Engine automatically invokes draw() every frame as well. If we want to make sure mario gets drawn to
	 * the screen, we need to make sure to override this method and call mario's draw method.
	 * */
	@Override
	public void draw(Graphics g){
		super.draw(g);
		
		/* Same, just check for null in case a frame gets thrown in before Mario is initialized */
		if(mario != null){
		    String[] frames = {"mario_walk_0.png", "mario_walk_1.png", "mario_walk_2.png"};
		    mario.initializeFrames(frames);

		    mario.setAnimation(new Animation("walk", 0, 2));
            mario.animate(mario.getAnimation("walk"));

		    mario.draw(g);
        }
	}

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		LabTwoGame game = new LabTwoGame();
		game.start();

	}
}
