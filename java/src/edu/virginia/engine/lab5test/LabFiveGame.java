package edu.virginia.engine.lab5test;

import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Hitbox;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.display.SoundManager;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabFiveGame extends Game{

    int framevcounter= 0;
    boolean won = false;
    int score = 5000;

    boolean mario_in_air = true;
    double airtime = 0.0;
    double velocity = 0.0;
    double acceleration = 9.8;
	/* Create a sprite object for our game. We'll use mario */
	Sprite mario = new Sprite("Mario", "Mario.png");
    Sprite goomba = new Sprite("Goomba", "Goomba.png", new Point(200,200));
    Sprite peach = new Sprite("Peach", "Peach.png", new Point(400,300));
    SoundManager sm = new SoundManager();
	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabFiveGame() {
		super("Lab Five Test Game", 750, 750);
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

        if(pressedKeys.contains(VK_P)){
            mario_in_air = true;
            velocity = -40;
            mario.setPosition(new Point((int) mario.getPosition().x,
                    (int) mario.getPosition().y-1));
        }

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

		    if (mario_in_air) {
		        airtime = airtime + 0.01;
		        velocity = velocity +  (acceleration * airtime);
		        System.out.println(airtime);
		        Gravity(mario, airtime, velocity, acceleration);
            } else {
		        if (mario.getPosition().y < 500) {
		            mario_in_air = true;
                }
            }


            if (goomba != null)
                if (mario.collidesWith(goomba)) {
                    //sm.PlaySoundEffect("woops");
                    sm.PlaySoundEffect("mammamia");
                    score -= 10;
                }
            if (peach != null)
                if (mario.collidesWith(peach)) {
                    sm.PlaySoundEffect("win");
                    won = true;
                }

            mario.update(pressedKeys);
		}
    }
	public void Gravity(Sprite m, double t, double v, double a) {
	    if (m.getPosition().y < 500) {
	        int offset = (int) ((v * t)+ (0.5 * a * t * t));
            m.setPosition(new Point((int) m.getPosition().x,
                    (int) m.getPosition().y  + offset));
        } else {
	        mario_in_air = false;
	        airtime = 0;
	        velocity = 0;
        }
    }
    //9.807 m/s^2 is earth's gravity acceleration constant
    // d = vt + 1/2 at^2
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
        else if(won) {
            g2d.drawString("YOU WIN!", 330, 330);
            //sm.PlaySoundEffect("win");
        }
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

        sm.LoadMusic("theme", "resources/mario_theme.wav");
        sm.LoadMusic("theme2", "resources/mario_star.wav");

        sm.LoadSoundEffect("win", "resources/mario_congratulations.wav");
        sm.LoadSoundEffect("mammamia", "resources/mario_mammamia.wav");
        sm.LoadSoundEffect("woops", "resources/mk64_item_drop.wav");

        sm.PlayMusic("theme2");

        System.out.println("does mario have physics?" + mario.getHasPhysics());
        mario.setHasPhysics(true);
        System.out.println("does mario have physics?" + mario.getHasPhysics());

    }

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		LabFiveGame game = new LabFiveGame();
		game.setup();
		game.start();

	}
}
