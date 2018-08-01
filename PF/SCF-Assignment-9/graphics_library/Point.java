package SCF_Assignment_9.graphics_library;

import graphics_library.Screen.ScreenException;

/**
 * This Circle class implements Shape interface
 * 
 * @author Ayushi Khandelwal
 *
 */
public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint) throws ScreenException {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			throw new ScreenException("Point out of Screen Size");
		}
	}

	boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
			return true;
		}
		return false;
	}

	public double getxPoint() {
		return xPoint;
	}

	public double getyPoint() {
		return yPoint;
	}
}
