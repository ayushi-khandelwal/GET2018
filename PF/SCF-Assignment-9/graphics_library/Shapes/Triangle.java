package SCF_Assignment_9.graphics_library.Shapes;

import SCF_Assignment_9.graphics_library.Point;
import graphics_library.Screen.ScreenException;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Circle class implements Shape interface
 * 
 * @author Ayushi Khandelwal
 *
 */
public class Triangle implements Shape {
	private Point origin;
	private Point pointA;
	private Point pointB;
	private double height;
	private double base;
	private double sideA;
	private double sideB;
	private double slopeA;
	private double slopeB;
	final Date timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Triangle(double height, double base, double sideA, Point origin, Date timestamp) throws ScreenException {
		this.height = height;
		this.base = base;
		this.sideA = sideA;
		computeOtherParameters();
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		double perimeter = getPerimeter() / 2;
		return Double.parseDouble(decimalFormatSpecifier
				.format(Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - base))));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(sideA + sideB + base));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (isPointEnclosed.getyPoint() - slopeA * isPointEnclosed.getxPoint() <= origin.getyPoint()
				- slopeA * origin.getyPoint()
				&& isPointEnclosed.getyPoint() - slopeB * isPointEnclosed.getxPoint() <= pointA.getyPoint()
						- slopeB * pointA.getxPoint()
				&& isPointEnclosed.getyPoint() >= origin.getyPoint()) {
			return true;
		}
		return false;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	private void computeOtherParameters() throws ScreenException {
		double difference = Math.sqrt(Math.pow(sideA, 2) - Math.pow(height, 2));
		double otherDifference = base - difference;
		sideB = Math.sqrt(Math.pow(height, 2) + Math.pow(otherDifference, 2));
		pointA = new Point(origin.getxPoint() + difference, origin.getyPoint() + height);
		pointB = new Point(origin.getxPoint() + base, origin.getyPoint());
		slopeA = (pointA.getyPoint() - origin.getyPoint()) / (pointA.getxPoint() - origin.getxPoint());
		slopeB = (pointA.getyPoint() - pointB.getyPoint()) / (pointA.getxPoint() - pointB.getxPoint());
		;
	}
}
