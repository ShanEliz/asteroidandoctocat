


/* Homework 4 Asteroids Game
 * 
 * Class that represents an Asteroid object
 * 
 * Shannon Mellin
 * 
 * October 13, 2017
 */

// imports
import java.awt.*;

public class Asteroid extends Polygon {


	public Asteroid(Point[] shape, Point position, double rotation) {
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

		brush.drawPolygon(x, y, points.length);
	}


	// Detect if there was a collision
	public boolean collision(Polygon poly) {
		Point[] points = poly.getPoints();
		for(Point p : points) {
			if(this.contains(p)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public void move() {
		// Point newPosition = new Point(this.position.x+1, this.position.y+1);
		// this.position = newPosition;

		/**
		 * Have asteroid move back on the screen once they go off the screen.
		 *
		 * You will do this by checking the value of position.x and position.y
		 * and determine if they are outside of the bounds of the screen
		 * specified by Asteroids.SCREEN_WIDTH and Asteroids.SCREEN_HEIGHT
		 * If so, reposition the x and/or y coordinates.
		 * 
		 * i.e. if an asteroid moves off the right-side of the screen
		 * have it re-appear on the left side of the screen.
		 */
		position.x += Math.cos(Math.toRadians(rotation));
		position.y += Math.sin(Math.toRadians(rotation));

		int sw = Asteroids.SCREEN_WIDTH;
		int sh = Asteroids.SCREEN_HEIGHT;

		if (position.x > (double) sw) {
			position.x -= sw;
		}

		else if (position.x < 0) {
			position.x += sw;
		}

		if (position.y > (double) sh) {
			position.y -= sh;
		}

		else if (position.y < 0) {
			position.y += sh;
		}

	}

}


