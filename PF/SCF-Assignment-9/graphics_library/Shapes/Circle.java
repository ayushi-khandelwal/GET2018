package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;

public class Circle implements Shape {
	double radius;
	Point centerPoint;
	Shape.ShapeType shape = Shape.ShapeType.Circle;
	
	public Circle(double radius, Point centerPoint) {
		this.radius = radius;
		this.centerPoint = centerPoint;
	}

	@Override
	public double getArea() {
		return (Math.PI * radius * radius);
	}

	@Override
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}

	@Override
	public Point getOrigin() {
		double originX = 0.0;
		double originY = 0.0;
		Point originPoint = new Point(originX, originY);
		originX = centerPoint.x - radius;
		originY = centerPoint.y - radius;
		return originPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		
		return true;
	}

	@Override
	public ShapeType getShapeType() {
		return shape;
	}
	
}
