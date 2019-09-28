


/* Homework 4 Asteroids Game
 * 
 * Makes bullets that fire from the Ship
 * 
 * Shannon Mellin
 * 
 * November 10, 2017
 */

// imports
import java.awt.*;
import java.util.ArrayList;

public class Bullet extends Circle {

	double rotation;
	final static int RADIUS = 5;

	public Bullet(Point center, double rotation) {
		super(center, RADIUS); // define RADIUS in Bullet class
		this.rotation = rotation;
	}

	public boolean outOfBounds() {
		double sw = Asteroids.SCREEN_WIDTH;
		double sh = Asteroids.SCREEN_HEIGHT;

		if (center.x > sw) {
			return true;
		}

		else if (center.x < 0) {
			return true;
		}

		else if (center.y > sh) {
			return true;
		}

		else if (center.y < 0) {
			return true;
		}

		else
			return false;
	}

	public boolean getOutOfBounds() {
		return outOfBounds();
	}

	@Override
	public void paint(Graphics brush, Color color) {
		brush.setColor(color);
		brush.fillOval((int) center.x, (int) center.y, radius, radius);
	}


	@Override
	public void move() {
		center.x += 2 * Math.cos(Math.toRadians(rotation));
		center.y += 2 * Math.sin(Math.toRadians(rotation));
	}

}


