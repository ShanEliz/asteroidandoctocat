


/* Homework 4 Asteroids Game
 * 
 * Makes stars in the background to look like space
 * 
 * Shannon Mellin
 * 
 * November 3, 2017
 */

// imports
import java.awt.*;

public class Star extends Circle {

	public Star(Point center, int radius) {
		super(center, radius);
	}


	@Override
	public void paint(Graphics brush, Color color) {
		brush.setColor(color);
		brush.fillOval((int) center.x, (int) center.y, radius, radius);
	}


	@Override
	public void move() {
	}

}

