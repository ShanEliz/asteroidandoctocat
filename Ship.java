

/* Homework 4 Asteroids Game 
 * 
 * Ship class, A representation of a ship
 * 
 * Shannon Mellin
 * 
 * October 26, 2017
 */

// imports
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Ship extends Polygon implements KeyListener {
	public static final int SHIP_WIDTH = 40;
	public static final int SHIP_HEIGHT = 25;
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();

	// move
	boolean forward = false, left = false, right = false;

	// shoot
	boolean fire = false, fired = false;


	public Ship(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
	}


	@Override
	public void paint(Graphics brush, Color color) {
		Point[] points = getPoints();

		int[] x = new int[points.length];
		int[] y = new int[points.length];

		for(int i = 0; i < points.length; i++) {
			x[i] = (int) points[i].x;
			y[i] = (int) points[i].y;
		}

		brush.setColor(color);
		brush.fillPolygon(x, y, points.length);
	}


	public ArrayList<Bullet> getBullets() {
		return bullet;
	}


	@Override
	public void move() {

		// we'll just demonstrate the ship moving across the x axis.
		/*
				position.x += 5;
		//  or
				position.x += Math.cos(Math.toRadians(rotation));
				position.y += Math.sin(Math.toRadians(rotation));
				Point newPosition = new Point(this.position.x+2, this.position.y);
				this.position = newPosition;

				position.x += 3 * Math.cos(Math.toRadians(rotation));
				position.y += 3 * Math.sin(Math.toRadians(rotation));
		 */

		// Check forward movement
		if (forward == true) {
			position.x += 3 * Math.cos(Math.toRadians(rotation));
			position.y += 3 * Math.sin(Math.toRadians(rotation));
		}

		// Check rotation to left
		if (left == true) {
			rotation -= 2;
		}

		// Check rotation to right
		if (right == true) {
			rotation += 2;
		}

		// When fired
		if (fire == true) {
			if (fired == true) {
				Bullet shot = new Bullet(getPoints()[3], rotation);  // change the three if needed
				bullet.add(shot);
				fired = false;
			}
		}


		double sw = Asteroids.SCREEN_WIDTH;
		double sh = Asteroids.SCREEN_HEIGHT;

		if (position.x > sw) {
			position.x -= sw;
		}

		else if (position.x < 0) {
			position.x += sw;
		}

		if (position.y > sh) {
			position.y -= sh;
		}

		else if (position.y < 0) {
			position.y += sh;
		}
	}


	/**
	 * Following methods set appropriate boolean values when
	 * arrow keys are pressed.
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			forward = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			fire = true;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			forward = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			fire = false;
			fired = true;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

}


