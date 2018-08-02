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
public class Circle implements Shape {

	private final double radius;
	private final Point origin;
	private final Date timestamp;
	private DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Circle(double radius, Point origin, Date timestamp) throws ScreenException {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
		Point originPoint = getOrigin();
		if (originPoint == null) {
			throw new NullPointerException("Circle is out of Screen");
		}
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(Math.PI * radius * radius));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * Math.PI * radius));
	}

	@Override
	public Point getOrigin() {
		double valueOfX1;
		double valueOfX2;
		double valueOfY;
		double A;
		double B;
		double C;
		double M = origin.getyPoint() / origin.getxPoint();

		/*
		 * y = mx so we will substitute the value of y to circle equation (x-h)2 +
		 * (y-k)2 = r2 where (h,k) is the radius coordinate x2(m2 + 1) - 2x(mx + h) + k2
		 * + h2 - r2 = 0 is the equation we get after substitution of y This equation is
		 * similar to Ax2 + Bx + C = 0 so we can easily calculate roots of x by formula
		 * of Quadratic Equation
		 */
		A = (Math.pow(M, 2) + 1);
		B = (-2 * (M * origin.getyPoint() + origin.getxPoint()));
		C = (Math.pow(origin.getyPoint(), 2) + Math.pow(origin.getxPoint(), 2) - Math.pow(radius, 2));
		double underRoot = Math.sqrt((Math.pow(B, 2) - 4 * A * C));
		valueOfX1 = (-B + underRoot) / (2 * A);
		valueOfX2 = (-B - underRoot) / (2 * A);

		/*
		 * We will get two coordinates of x so we will select only that coordinate whose
		 * value is less than the x coordinate of radius
		 */
		if (valueOfX1 <= origin.getxPoint() && valueOfX2 <= 1920) {
			valueOfY = M * valueOfX1;
			try {
				return new Point(valueOfX1, valueOfY);
			} catch (ScreenException e) {
				e.printStackTrace();
			}
		} else if (valueOfX2 <= origin.getxPoint() && valueOfX1 <= 1920) {
			valueOfY = M * valueOfX2;
			try {
				return new Point(valueOfX2, valueOfY);
			} catch (ScreenException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * If the given point is enclosed in circle then (x-h)2 + (y-k)2 <= r2 should
	 * satisfy where (h,k) is the point that is Enclosed or not
	 */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (Math.pow(origin.getxPoint() - isPointEnclosed.getxPoint(), 2)
				+ Math.pow(origin.getyPoint() - isPointEnclosed.getyPoint(), 2) <= Math.pow(radius, 2)) {
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
		return ShapeType.Circle;
	}
}
