package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;

public class Triangle implements Shape{
	double base;
	Point point;
	Point point1;
	Point point2;
	Point point3;
	Shape.ShapeType shape = Shape.ShapeType.Triangle;
	
	public Triangle(double base, Point point1, Point point2, Point point3) {
		this.base = base;;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
	
	@Override
	public double getArea() {
		return ((Math.sqrt(3)/4) * base * base);
	}

	@Override
	public double getPerimeter() {
		return (3 * base);
	}

	@Override
	public Point getOrigin() {
		return point1;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(point1.x <= point.x && point1.y <= point.y)
			if(point.x <= point2.x && point.y <= point2.y)
				if(point.x <= point3.x && point.y <= point3.y)
					return true; 
		return false;
	}

	@Override
	public ShapeType getShapeType() {
		return shape;
	}

}
