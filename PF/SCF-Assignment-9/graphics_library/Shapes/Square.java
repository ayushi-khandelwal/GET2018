package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;

public class Square implements Shape{
	double width;
	Point pointMin;
	Point pointMax;
	Shape.ShapeType shape = Shape.ShapeType.Square;
	
	
	public Square(double width, Point pointMin, Point pointMax) {
		this.width = width;
		this.pointMin = pointMin;
		this.pointMax = pointMax;
	}
	
	@Override
	public double getArea() {
		return (width * width);
	}

	@Override
	public double getPerimeter() {
		return (4 * width);
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
	
	/** @return Shape Type */
	@Override
	public ShapeType getShapeType(){
		return shape;
	}
}
