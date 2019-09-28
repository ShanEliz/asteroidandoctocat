


/**
 * CLASS: AsteroidsGame
 * DESCRIPTION: Extending Game, Asteroids is all in the paint method.
 * NOTE: This class is the metaphorical "main method" of your program,
 *       it is your control center.
 * Original code by Dan Leyzberg and Art Simon
 * Modified by Shannon Mellin
 */

// imports
import java.awt.*;
import java.util.*;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	static int counter = 0;
	int countdown = 0;

	// Creates asteroids
	/*
		public double rotation;
		private Asteroid firstAsteriod;
		private Asteroid secondAsteriod;
		private Asteroid thirdAsteriod;
	 */
	private java.util.List<Asteroid> randomAsteroids = new ArrayList<Asteroid>();

	// creates stars
	private Star[] randomStars;

	// creates a ship
	private Ship ship1;

	// creates an octocat
	private OctoCat body;
	private OctoCat face;
	private OctoCat leftEye;
	private OctoCat rightEye;
	private OctoCat nose;
	private OctoCat mouth;


	// Create a certain number of stars with a given max radius
	public Star[] createStars(int numberOfStars, int maxRadius) {
		Star[] stars = new Star[numberOfStars];
		for(int i = 0; i < numberOfStars; ++i) {
			Point center = new Point
					(Math.random() * SCREEN_WIDTH, Math.random() * SCREEN_HEIGHT);
			int radius = (int) (Math.random() * maxRadius);
			if(radius < 1) {
				radius = 1;
			}
			stars[i] = new Star(center, radius);
		}
		return stars;
	}


	public Asteroids() {
		super("Asteroids!", SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setFocusable(true);
		this.requestFocus();

		// create random stars in the background
		randomStars = createStars(100, 5);

		// create a number of random asteroid objects
		randomAsteroids = createRandomAsteroids(10,60,30);
		//  or
		/*
				Point[] first = new Point[4];
				first[0] = new Point(100, 100);
				first[1] = new Point(100, 230);
				first[2] = new Point(80, 300);
				first[3] = new Point(50, 150);
				Point firstPosition = new Point(100, 100);
				firstAsteriod = new Asteroid(first, firstPosition, 250);

				Point[] second = new Point[5];
				second[0] = new Point(360, 400);
				second[1] = new Point(300, 450);
				second[2] = new Point(200, 525);
				second[3] = new Point(350, 550);
				second[4] = new Point(410, 500);
				Point secondPosition = new Point(300, 300);
				secondAsteriod = new Asteroid(second, secondPosition, 180);

				Point[] third = new Point[3];
				third[0] = new Point(120, 450);
				third[1] = new Point(200, 500);
				third[2] = new Point(160, 600);
				Point thirdPosition = new Point(200, 500);
				thirdAsteriod = new Asteroid(third, thirdPosition, 90);
		 */

		// create all shapes necessary for an octocat
		Point[] octocat = new Point[64];
		octocat[0] = new Point(243, 140);
		octocat[1] = new Point(250, 131);
		octocat[2] = new Point(253, 143);
		octocat[3] = new Point(256, 150);
		octocat[4] = new Point(256, 160);
		octocat[5] = new Point(280, 160);
		octocat[6] = new Point(280, 159);
		octocat[7] = new Point(256, 159);
		octocat[8] = new Point(256, 164);
		octocat[9] = new Point(280, 164);
		octocat[10] = new Point(280, 163);
		octocat[11] = new Point(256, 163);
		octocat[12] = new Point(256, 165);
		octocat[13] = new Point(253, 173);
		octocat[14] = new Point(238, 176);
		octocat[15] = new Point(243, 183);
		octocat[16] = new Point(246, 191);
		octocat[17] = new Point(246, 216);
		octocat[18] = new Point(250, 220);
		octocat[19] = new Point(245, 220);
		octocat[20] = new Point(241, 217);
		octocat[21] = new Point(241, 200);
		octocat[22] = new Point(237, 195);
		octocat[23] = new Point(237, 223);
		octocat[24] = new Point(235, 226);
		octocat[25] = new Point(233, 223);
		octocat[26] = new Point(233, 195);
		octocat[27] = new Point(230, 191);
		octocat[28] = new Point(228, 195);
		octocat[29] = new Point(228, 223);
		octocat[30] = new Point(226, 226);
		octocat[31] = new Point(224, 223);
		octocat[32] = new Point(224, 195);
		octocat[33] = new Point(220, 200);
		octocat[34] = new Point(220, 217);
		octocat[35] = new Point(216, 220);
		octocat[36] = new Point(210, 220);
		octocat[37] = new Point(215, 216);
		octocat[38] = new Point(215, 195);
		octocat[39] = new Point(208, 197);
		octocat[40] = new Point(201, 195);
		octocat[41] = new Point(195, 190);
		octocat[42] = new Point(188, 185);
		octocat[43] = new Point(184, 181);
		octocat[44] = new Point(192, 182);
		octocat[45] = new Point(204, 188);
		octocat[46] = new Point(211, 186);
		octocat[47] = new Point(218, 183);
		octocat[48] = new Point(223, 176);
		octocat[49] = new Point(208, 173);
		octocat[50] = new Point(205, 165);
		octocat[51] = new Point(205, 164);
		octocat[52] = new Point(181, 164);
		octocat[53] = new Point(181, 163);
		octocat[54] = new Point(205, 163);
		octocat[55] = new Point(205, 160);
		octocat[56] = new Point(181, 160);
		octocat[57] = new Point(181, 159);
		octocat[58] = new Point(205, 159);
		octocat[59] = new Point(205, 150);
		octocat[60] = new Point(208, 143);
		octocat[61] = new Point(210, 131);
		octocat[62] = new Point(218, 140);
		octocat[63] = new Point(243, 140);
		Point octoCatPosition = new Point(200, 200);
		body = new OctoCat(octocat, octoCatPosition, 0);

		Point[] facePoint = new Point[9];
		facePoint[0] = new Point(220, 172);
		facePoint[1] = new Point(214, 168);
		facePoint[2] = new Point(214, 156);
		facePoint[3] = new Point(220, 152);
		facePoint[4] = new Point(240, 152);
		facePoint[5] = new Point(246, 156);
		facePoint[6] = new Point(246, 168);
		facePoint[7] = new Point(240, 172);
		facePoint[8] = new Point(220, 172);
		Point facePosition = new Point(217, 206);
		face = new OctoCat(facePoint, facePosition, 0);

		Point[] leftEyePoint = new Point[9];
		leftEyePoint[0] = new Point(220, 166);
		leftEyePoint[1] = new Point(218, 164);
		leftEyePoint[2] = new Point(218, 156);
		leftEyePoint[3] = new Point(220, 154);
		leftEyePoint[4] = new Point(224, 154);
		leftEyePoint[5] = new Point(226, 156);
		leftEyePoint[6] = new Point(226, 164);
		leftEyePoint[7] = new Point(224, 166);
		leftEyePoint[8] = new Point(220, 166);
		Point leftEyePosition = new Point(217, 206);
		leftEye = new OctoCat(leftEyePoint, leftEyePosition, 0);

		Point[] rightEyePoint = new Point[9];
		rightEyePoint[0] = new Point(236, 166);
		rightEyePoint[1] = new Point(234, 164);
		rightEyePoint[2] = new Point(234, 156);
		rightEyePoint[3] = new Point(236, 154);
		rightEyePoint[4] = new Point(240, 154);
		rightEyePoint[5] = new Point(242, 156);
		rightEyePoint[6] = new Point(242, 156);
		rightEyePoint[7] = new Point(240, 166);
		rightEyePoint[8] = new Point(236, 166);
		Point rightEyePosition = new Point(230, 206);
		rightEye = new OctoCat(rightEyePoint, rightEyePosition, 0);

		Point[] nosePoint = new Point[4];
		nosePoint[0] = new Point(229, 168);
		nosePoint[1] = new Point(229, 166);
		nosePoint[2] = new Point(231, 166);
		nosePoint[3] = new Point(231, 168);
		Point nosePosition = new Point(226, 217);
		nose = new OctoCat(nosePoint, nosePosition, 0);


		Point[] mouthPoint = new Point[4];
		mouthPoint[0] = new Point(227, 170);
		mouthPoint[1] = new Point(229, 171);
		mouthPoint[2] = new Point(231, 171);
		mouthPoint[3] = new Point(233, 170);
		Point mouthPosition = new Point(224, 220);
		mouth = new OctoCat(mouthPoint, mouthPosition, 0);

		// create the ship
		ship1 = createShip();
		this.addKeyListener(ship1);
		//  or
		//		Point[] shipPoint = new Point[4];
		//		shipPoint[0] = new Point(400, 300);
		//		shipPoint[1] = new Point(368, 287);
		//		shipPoint[2] = new Point(375, 300);
		//		shipPoint[3] = new Point(368, 313);
		//		Point position = new Point(400, 300);
		//		ship1 = new Ship(shipPoint, position, 0);
	}


	// private helper method to create the Ship
	private Ship createShip() {
		// Look of ship
		Point[] shipShape = {
				new Point(0, 0),
				new Point(Ship.SHIP_WIDTH/3.5, Ship.SHIP_HEIGHT/2),
				new Point(0, Ship.SHIP_HEIGHT),
				new Point(Ship.SHIP_WIDTH, Ship.SHIP_HEIGHT/2)
		};
		// Set ship at the middle of the screen
		Point startingPosition = new Point((width -Ship.SHIP_WIDTH)/2, (height - Ship.SHIP_HEIGHT)/2);
		int startingRotation = 0; // Start facing to the right
		return new Ship(shipShape, startingPosition, startingRotation);
	}


	//  Create an array of random asteroids
	private java.util.List<Asteroid> createRandomAsteroids(int numberOfAsteroids, int maxAsteroidWidth,
			int minAsteroidWidth) {
		java.util.List<Asteroid> asteroids = new ArrayList<>(numberOfAsteroids);

		for(int i = 0; i < numberOfAsteroids; ++i) {
			// Create random asteroids by sampling points on a circle
			// Find the radius first.
			int radius = (int) (Math.random() * maxAsteroidWidth);
			if(radius < minAsteroidWidth) {
				radius += minAsteroidWidth;
			}
			// Find the circles angle
			double angle = (Math.random() * Math.PI * 1.0/2.0);
			if(angle < Math.PI * 1.0/5.0) {
				angle += Math.PI * 1.0/5.0;
			}
			// Sample and store points around that circle
			ArrayList<Point> asteroidSides = new ArrayList<Point>();
			double originalAngle = angle;
			while(angle < 2*Math.PI) {
				double x = Math.cos(angle) * radius;
				double y = Math.sin(angle) * radius;
				asteroidSides.add(new Point(x, y));
				angle += originalAngle;
			}
			// Set everything up to create the asteroid
			Point[] inSides = asteroidSides.toArray(new Point[asteroidSides.size()]);
			Point inPosition = new Point(Math.random() * SCREEN_WIDTH, Math.random() * SCREEN_HEIGHT);
			double inRotation = Math.random() * 360;
			asteroids.add(new Asteroid(inSides, inPosition, inRotation));
		}
		return asteroids;
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);

		// display/paint the stars
		brush.setColor(Color.white);
		for (int i = 0; i < randomStars.length; i++) {
			randomStars[i].paint(brush, Color.white);
		}
		
		// display/paint the bullets
		ArrayList<Bullet> shots = ship1.getBullets();
		ArrayList<Bullet> shots2 = ship1.getBullets();   /// need to finish with this!!!!!!!!!!!!!!!
		for (Bullet shot : shots) {
			brush.setColor(Color.red);
			shot.paint(brush,Color.red);
			shot.move();
//			if (shot.outOfBounds() == true) {
//				shots2.add(shot);
//			}
		}
		
//		for (Bullet offScreen : shots2) {
//			ship1.getBullets().remove(offScreen);
//		}
//		shots2.clear();

		// display/paint the octocat
		body.move();
		brush.setColor(Color.cyan);
		body.paint(brush, Color.cyan);

		face.move();
		brush.setColor(Color.lightGray);
		face.paint(brush, Color.lightGray);

		leftEye.move();
		brush.setColor(Color.black);
		leftEye.paint(brush, Color.black);

		rightEye.move();
		brush.setColor(Color.red);
		rightEye.paint(brush, Color.red);

		nose.move();
		brush.setColor(Color.black);
		nose.paint(brush, Color.black);

		mouth.move();
		brush.setColor(Color.black);
		mouth.paint(brush, Color.black);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter,10,10);

		// display/paint the random asteroids
		for (Asteroid asteroid : randomAsteroids) {
			brush.setColor(Color.white);
			asteroid.paint(brush,Color.white);
			asteroid.move();

			// start a one second count down if there is a collision
			if (asteroid.collision(ship1) == true) {
				countdown = 100;
			}
		}
		//  or
		/*
				for (int i = 0; i < randomAsteroids.size(); i++) {
					randomAsteroids.get(i).paint(brush, Color.white);
					randomAsteroids.get(i).move();
				}
		 */
		//  or
		/*
				firstAsteriod.move();
				firstAsteriod.paint(brush, Color.white);
				secondAsteriod.move();
				secondAsteriod.paint(brush, Color.white);
				thirdAsteriod.move();
				thirdAsteriod.paint(brush, Color.white);
		 */

		// display/paint the ship
		ship1.move();
		if (countdown == 0)
			ship1.paint(brush, Color.red);
		else {
			ship1.paint(brush, Color.yellow);  // if coundown is activated turn ship to yellow
			countdown--;  // count down from 100
		}
	}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
	}
}


