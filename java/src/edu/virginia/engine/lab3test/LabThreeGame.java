package edu.virginia.engine.lab3test;

import edu.virginia.engine.display.DisplayObject;

import edu.virginia.engine.display.Planet;

import edu.virginia.engine.display.Sprite;

import edu.virginia.engine.display.DisplayObjectContainer;
import edu.virginia.engine.display.Game;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabThreeGame extends Game{

    //Variable to change the direction of the rotation. 1: CW; -1: CCW
    int dir = 1;

    //Background Sprite to draw stars
    Sprite stars = new Sprite("Stars", "BigdipISS2.jpg", new Point(0,0));

    //Sun
	Planet sun = new Planet("Sun", "FakeSun.png", null, new Point(3000,3000));

	//Planets and asteroids
    Planet mercury = new Planet("mercury", "Mercurys.png", sun, new Point(1925,1925));
    Planet venus = new Planet("venus", "Venuss.png", sun, new Point(1710,1710));
    Planet earth = new Planet("earth", "Earths.png", sun, new Point(1420,1420));
    Planet mars = new Planet("mars", "Marss.png", sun, new Point(1150,1150));
    Planet jupiter = new Planet("jupiter", "Jupiters.png", sun, new Point(-50,-50));
    Planet saturn = new Planet("saturn", "Saturns.png", sun, new Point(-700,-700));
    Planet uranus = new Planet("uranus", "Uranuss.png", sun, new Point(-1000,-1000));
    Planet neptune = new Planet("neptune", "Neptunes.png", sun, new Point(-1500,-1500));
    Planet pluto = new Planet("pluto", "Moon.png", sun, new Point(1500,1500));
    Planet asteroids = new Planet("asteroids", "Solsa.png", sun, new Point(0,0));

    //Moons
    Planet moon = new Planet("moon", "Moons.png", earth, new Point(-50,-50));
    Planet jmoon1 = new Planet("moon", "Moons.png", jupiter, new Point(-50,-50));
    Planet jmoon2 = new Planet("moon", "Moons.png", jupiter, new Point(-150,-150));
    Planet nmoon = new Planet("moon", "Moons.png", neptune, new Point(-50,-50));

	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabThreeGame() {
		super("Lab Three Test Game", 750, 750);
	}

    /**
     * Method to initialize things: add children, set pivots, set rotation speeds
     * */
    public void setup() {
        //Add children of sun
        sun.addChild(mercury);
        sun.addChild(venus);
        sun.addChild(earth);
        sun.addChild(mars);
        sun.addChild(jupiter);
        sun.addChild(saturn);
        sun.addChild(neptune);
        sun.addChild(uranus);
        sun.addChild(asteroids);
        sun.addChild(pluto);

        //Add children of planets
        earth.addChild(moon);
        jupiter.addChild(jmoon1);
        jupiter.addChild(jmoon2);
        neptune.addChild(nmoon);

        //Set planet rotation speeds
        sun.setRotateSpeed(Math.PI/500);
        mercury.setRotateSpeed(Math.PI/30);
        venus.setRotateSpeed(Math.PI/50);
        earth.setRotateSpeed(Math.PI/80);
        mars.setRotateSpeed(Math.PI/90);
        jupiter.setRotateSpeed(Math.PI/200);
        saturn.setRotateSpeed(Math.PI/250);
        uranus.setRotateSpeed(Math.PI/500);
        neptune.setRotateSpeed(Math.PI/800);
        asteroids.setRotateSpeed(Math.PI/800);
        pluto.setRotateSpeed(Math.PI/30);

        //Set moon rotation speeds
        moon.setRotateSpeed(Math.PI/30);
        jmoon1.setRotateSpeed(Math.PI/50);
        nmoon.setRotateSpeed(Math.PI/20);
        //Jupiter's second moon goes backwards!
        jmoon2.setRotateSpeed(-Math.PI/30);

        //Make some orbits elliptical
        pluto.setEllipse(true);
        pluto.setOrbitRadius(50);
        nmoon.setEllipse(true);
        nmoon.setOrbitRadius(10);

        //Set pivot points: Sun's center
        sun.setPivotPoint(new Point(sun.getScaledWidth()/2,
                sun.getScaledHeight()/2));
        for (DisplayObject child : sun.getChildren()) {
            child.setPivotPoint(new Point(-child.getPosition().x+(sun.getUnscaledWidth()/2),
                    -child.getPosition().y+sun.getUnscaledHeight()/2));
            if(child instanceof DisplayObjectContainer)
            for (DisplayObject grandchild : ((DisplayObjectContainer)child).getChildren())
                grandchild.setPivotPoint(new Point(-grandchild.getPosition().x+child.getUnscaledWidth()/2,
                        -grandchild.getPosition().y+child.getUnscaledHeight()/2));
        }
    }

    /**
     * Off-center elliptical orbit
     * */
    private void elliptic(Planet planet, double a)
    {
        //Change the direction the pivot point travels based on how much of an orbit is complete
        if((planet.getRotation()%(2*Math.PI))<Math.PI)
            planet.setOrbitRadDir(1);
        else if((planet.getRotation()%(2*Math.PI))<(2*Math.PI))
            planet.setOrbitRadDir(-1);

        //Move pivot
        planet.setPivotPoint(new Point(planet.getPivotPoint().x+(planet.getOrbitRadDir()*planet.getOrbitRadius()),
                planet.getPivotPoint().y+(planet.getOrbitRadDir()*planet.getOrbitRadius())));
        planet.setRotation(planet.getRotation()+a);
    }

	/**
	 * Engine will automatically call this update method once per frame and pass to us
	 * the set of keys (as strings) that are currently being pressed down
	 * */
	@Override
	public void update(ArrayList<Integer> pressedKeys){

	    super.update(pressedKeys);

		//Pan around display
        if(pressedKeys.contains(VK_LEFT)){ sun.setPosition(new Point((int) sun.getPosition().x+100,
                (int) sun.getPosition().y)); }
        if(pressedKeys.contains(VK_RIGHT)){ sun.setPosition(new Point((int) sun.getPosition().x-100,
                (int) sun.getPosition().y)); }
        if(pressedKeys.contains(VK_DOWN)){ sun.setPosition(new Point((int) sun.getPosition().x,
                (int) sun.getPosition().y-100)); }
        if(pressedKeys.contains(VK_UP)){ sun.setPosition(new Point((int) sun.getPosition().x,
                (int) sun.getPosition().y+100)); }

        //Zoom in and out; change sun's pivot so system rotates correctly
        if(pressedKeys.contains(VK_W)){
            sun.setScaleY(sun.getScaleY() + .03);
            sun.setScaleX(sun.getScaleX() + .03);
            sun.setPivotPoint(new Point(sun.getScaledWidth()/2,
                    sun.getScaledHeight()/2));
        }
        if(pressedKeys.contains(VK_Q)){
            sun.setScaleX(sun.getScaleX() - .03);
            sun.setScaleY(sun.getScaleY() - .03);
            sun.setPivotPoint(new Point(sun.getScaledWidth()/2,
                    sun.getScaledHeight()/2));
        }

        //Change direction of rotation
        if(pressedKeys.contains(VK_A)) {
           dir = 1;
        }
        if(pressedKeys.contains(VK_S)){
           dir = -1;
        }

		/* Make sure sun is not null.
		Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		if(sun != null){
		    //Rotate all planets and moons
            for (DisplayObject child : sun.getChildren()) {
                if (((Planet)child).getChildren()!=null) {
                    for (DisplayObject grandchild : ((DisplayObjectContainer) child).getChildren()) {
                        if(((Planet) grandchild).isEllipse()){
                            elliptic(((Planet) grandchild), ((Planet) grandchild).getRotateSpeed());
                        } else
                        grandchild.setRotation(grandchild.getRotation() + ((Planet) grandchild).getRotateSpeed());
                    }
                }
                if(((Planet) child).isEllipse()){
                    elliptic(((Planet) child), ((Planet) child).getRotateSpeed());
                } else
                    child.setRotation(child.getRotation() + dir*((Planet) child).getRotateSpeed());
            }
		    sun.update(pressedKeys);
        }


	}

	/**
	 * Engine automatically invokes draw() every frame as well.
	 * */
	@Override
	public void draw(Graphics g){

	    Graphics2D g2d = (Graphics2D) g;

	    //Set black background
        g2d.setColor(Color.black);
        g2d.setBackground(Color.black);
        g2d.fillRect(0, 0, 750, 750);

        //Set star background
//        g2d.scale(.5, .5);
//        stars.draw(g);
//        g2d.scale(2, 2);

        //Scale system to fit on screen; draw
        g2d.scale(.06, .06);
		super.draw(g);

		//Check for null in case a frame gets thrown in before sun is initialized
        //Translate to center of canvas before zooming; then draw
        if(sun != null) {
            g2d.translate(this.getUnscaledWidth()/.12,this.getUnscaledHeight()/.12);
            g2d.scale(sun.getScaleX(),sun.getScaleY());
            g2d.translate(-this.getUnscaledWidth()/.12,-this.getUnscaledHeight()/.12);
            sun.draw(g);
        }
	}

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls setup(), update(), and draw() every frame
	 * */
	public static void main(String[] args) {
		LabThreeGame game = new LabThreeGame();
		game.setup();
		game.start();
	}
}
