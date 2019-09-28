

/**
 * Makes a floating OctoCat
 * 
 * Shannon Mellin
 * 
 * October 27, 2017
 */

// imports
import java.awt.*;

public class OctoCat extends Polygon {

	public OctoCat(Point[] shape, Point position, double rotation) {
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

		brush.fillPolygon(x, y, points.length);
	}

	@Override
	public void move() {

		position.x += 3;
		//  or
		//		position.x += Math.cos(Math.toRadians(rotation));
		//		position.y += Math.sin(Math.toRadians(rotation));
		//		Point newPosition = new Point(this.position.x+2, this.position.y);
		//		this.position = newPosition;

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

}
