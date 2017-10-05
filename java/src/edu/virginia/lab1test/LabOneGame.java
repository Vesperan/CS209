package edu.virginia.lab1test;

import java.awt.*;
import java.util.ArrayList;

import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Sprite;

import static java.awt.event.KeyEvent.*;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabOneGame extends Game{

    int framevcounter= 0;
	/* Create a sprite object for our game. We'll use mario */
	Sprite mario = new Sprite("Mario", "Mario.png");
	
	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabOneGame() {
		super("Lab One Test Game", 500, 300);
	}
	
	/**
	 * Engine will automatically call this update method once per frame and pass to us
	 * the set of keys (as strings) that are currently being pressed down
	 * */
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);

		framevcounter++;

        if(pressedKeys.contains(VK_L)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x+5,
                (int) mario.getPivotPoint().y)); }
        if(pressedKeys.contains(VK_J)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x-5,
                (int) mario.getPivotPoint().y)); }
        if(pressedKeys.contains(VK_I)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x,
                (int) mario.getPivotPoint().y-5)); }
        if(pressedKeys.contains(VK_K)){ mario.setPivotPoint(new Point((int) mario.getPivotPoint().x,
                (int) mario.getPivotPoint().y+5)); }

        if(pressedKeys.contains(VK_RIGHT)){ mario.setPosition(new Point((int) mario.getPosition().x+5,
                (int) mario.getPosition().y)); }
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
		if(mario != null) mario.draw(g);
	}

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		LabOneGame game = new LabOneGame();
		game.start();

	}
}
