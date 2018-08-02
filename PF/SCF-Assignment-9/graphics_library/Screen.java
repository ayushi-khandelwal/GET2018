package SCF_Assignment_9.graphics_library;

import SCF_Assignment_9.graphics_library.Shapes.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Circle class implements Shape interface
 * 
 * @author Ayushi Khandelwal
 *
 */
public class Screen {
	static ArrayList<Shape> shapesList = new ArrayList<>();

	public Screen() throws ScreenException {
		addShape(ShapeType.Circle, new Point(200, 200), new ArrayList<>(Arrays.asList(50d)));
		addShape(ShapeType.Circle, new Point(400, 300), new ArrayList<>(Arrays.asList(30d)));
		addShape(ShapeType.Rectangle, new Point(1, 23), new ArrayList<>(Arrays.asList(12d, 23d)));
		addShape(ShapeType.Square, new Point(300, 100), new ArrayList<>(Arrays.asList(120d)));
		addShape(ShapeType.Triangle, new Point(40, 200), new ArrayList<>(Arrays.asList(120d, 200d, 200d)));
	}

	/**
	 * Adds Shape to shapeList
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @throws ScreenException
	 */
	void addShape(ShapeType shapeType, Point point, List<Double> parameters) throws ScreenException {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
	}

	/**
	 * Deletes the given Shape
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @return
	 * @throws ScreenException
	 */
	boolean deleteShape(ShapeType shapeType, Point point) throws ScreenException {
		if (shapeType == null || point == null) {
			throw new NullPointerException("Arguments in deleteShape can't be Null");
		}
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType
					&& shapesList.get(i).getOrigin().getxPoint() == point.getxPoint()) {
				shapesList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete all the given type of Specific Shapes
	 * 
	 * @param shapeType
	 */
	void deleteShapesOfSpecificType(ShapeType shapeType) {
		if (shapeType == null) {
			throw new NullPointerException("ShapeType can't be Null in deleteShapesOfSpecificType");
		}
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType) {
				shapesList.remove(i);
			}
		}
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Area
	 * 
	 * @return
	 * @throws ScreenException
	 */
	ArrayList<Shape> ascendingInArea() throws ScreenException {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1).getArea()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Perimeter
	 * 
	 * @return
	 * @throws ScreenException
	 */
	ArrayList<Shape> ascendingInPerimeter() throws ScreenException {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes.get(j + 1).getPerimeter()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Timestamp
	 * 
	 * @return
	 * @throws ScreenException
	 */
	ArrayList<Shape> ascendingInTimestamp() throws ScreenException {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimestamp().after(sortedShapes.get(j + 1).getTimestamp())) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Arranges Shapes in ascending order on the basis of Origin Distance
	 * 
	 * @return
	 * @throws ScreenException
	 */
	ArrayList<Shape> ascendingInOriginDistance() throws ScreenException {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getyPoint(), 2));
				double originDistanceJ1 = Math.sqrt(Math.pow(sortedShapes.get(j + 1).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin().getyPoint(), 2));
				if (originDistanceJ > originDistanceJ1) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	/**
	 * Returns all the Shapes that Enclose the given Point
	 * 
	 * @param point
	 * @return
	 */
	ArrayList<Shape> isPointEnclosed(Point point) {
		if (point == null) {
			throw new NullPointerException("Point can't be Null in isPointEnclosed");
		}
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}
		return pointEnclosedShapes;
	}

	@SuppressWarnings("serial")
	static class ScreenException extends Exception {
		String messageException;

		public ScreenException(String messageException) {
			this.messageException = messageException;
		}

		public String getMessageException() {
			return messageException;
		}
	}
}
