package edu.virginia.engine.lab4test;

import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Hitbox;
import edu.virginia.engine.display.Sprite;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabFourGame extends Game{

    int framevcounter= 0;
    boolean won = false;
    int score = 5000;
	/* Create a sprite object for our game. We'll use mario */
	Sprite mario = new Sprite("Mario", "Mario.png");
    Sprite goomba = new Sprite("Goomba", "Goomba.png", new Point(200,200));
    Sprite peach = new Sprite("Peach", "Peach.png", new Point(400,300));

	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabFourGame() {
		super("Lab Four Test Game", 750, 750);
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
		    System.out.println("Peach! " + peach.getPosition());
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
            mario.getHitbox().setBoxWidth(mario.getScaledWidth());
            mario.getHitbox().setBoxHeight(mario.getScaledHeight());
        }

        if(pressedKeys.contains(VK_S)) {
            mario.setScaleX(mario.getScaleX() - .1);
            mario.setScaleY(mario.getScaleY() - .1);
            mario.getHitbox().setBoxWidth(mario.getScaledWidth());
            mario.getHitbox().setBoxHeight(mario.getScaledHeight());
        }

		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		if(mario != null) {
            if (goomba != null)
                if (mario.collidesWith(goomba))
                    score -= 10;
            if (peach != null)
                if (mario.collidesWith(peach))
                    won = true;
            mario.update(pressedKeys);
		}
        }
	
	/**
	 * Engine automatically invokes draw() every frame as well. If we want to make sure mario gets drawn to
	 * the screen, we need to make sure to override this method and call mario's draw method.
	 * */
	@Override
	public void draw(Graphics g){
		super.draw(g);
		Graphics2D g2d = (Graphics2D) g;

        if(score < 0)
            g2d.drawString("YOU LOSE!", 330, 330);
        else if(won)
            g2d.drawString("YOU WIN!", 330, 330);
        else {
            g2d.drawString("Score: " + score, 620, 700);
		/* Same, just check for null in case a frame gets thrown in before Mario is initialized */
            if (goomba != null) {
                goomba.draw(g);
            }
            if (peach != null) {
                peach.draw(g);
            }
            if (mario != null) {
                mario.draw(g);
            }
        }
	}

    public void setup() {
        peach.setHitbox(peach.getScaledWidth(), peach.getScaledHeight(), "hitboxp.png");
        peach.addChild(peach.getHitbox());

        goomba.setHitbox(goomba.getScaledWidth(), goomba.getScaledHeight(), "hitboxg.png");
        goomba.addChild(goomba.getHitbox());

        mario.setHitbox(mario.getScaledWidth(), mario.getScaledHeight(), "hitboxm.png");
        mario.addChild(mario.getHitbox());
    }

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		LabFourGame game = new LabFourGame();
		game.setup();
		game.start();
	}
}
