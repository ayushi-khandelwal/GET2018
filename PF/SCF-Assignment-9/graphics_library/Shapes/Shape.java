package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;

public interface Shape {

	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point point);
	
	enum ShapeType{
		Square, Rectangle, Triangle, Circle;
	}

	public ShapeType getShapeType();

}
