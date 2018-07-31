package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;

public class Rectangle implements Shape{
	double width;
	double height;
	Point pointMin;
	Point pointMax;
	Shape.ShapeType shape = Shape.ShapeType.Rectangle;
	
	public Rectangle(double width, double height, Point pointMin, Point pointMax) {
		this.width = width;
		this.height = height;
		this.pointMin = pointMin;
		this.pointMax = pointMax;
	}
	
	@Override
	public double getArea() {
		return (width * height);
	}

	@Override
	public double getPerimeter() {
		return (2 * (width + height));
	}

	@Override
	public Point getOrigin() {
		return pointMin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(pointMin.x <= point.x && pointMin.y <= point.y)
			if(point.x <= pointMax.x && point.y <= pointMax.y)
				return true;  
		return false;
	}

	@Override
	public ShapeType getShapeType() {
		return shape;
	}

}
