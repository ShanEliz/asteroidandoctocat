/**
 * An interface representing a shape.
 * 
 * @author Alex Brown
 */

// imports
import java.awt.*;

public interface Shape {
	public void paint(Graphics brush, Color color);

	public void move();
}
