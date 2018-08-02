package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;
import graphics_library.Screen.ScreenException;

import java.util.Date;

/**
 * This Circle class implements Shape interface
 * 
 * @author Ayushi Khandelwal
 *
 */
public interface Shape {

	double getArea();

	double getPerimeter();

	Point getOrigin() throws ScreenException;

	boolean isPointEnclosed(Point isPointEnclosed);

	Date getTimestamp();

	ShapeType getShapeType();
}

enum ShapeType {
	Square, Rectangle, Circle, Triangle;
}
