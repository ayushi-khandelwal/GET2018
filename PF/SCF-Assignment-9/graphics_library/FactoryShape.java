package SCF_Assignment_9.graphics_library;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import SCF_Assignment_9.graphics_library.Shapes.Circle;
import SCF_Assignment_9.graphics_library.Shapes.Rectangle;
import SCF_Assignment_9.graphics_library.Shapes.Shape;
import SCF_Assignment_9.graphics_library.Shapes.Square;
import SCF_Assignment_9.graphics_library.Shapes.Triangle;

public class FactoryShape {
	
	public static Shape createShape(Shape.ShapeType shapeType, Point pointMin, Point pointMax, ArrayList<Double> list) {
		
		switch(shapeType) {
			case Circle:
				return new Circle(list.get(0), pointMax);

			case Rectangle:
				return new Rectangle(list.get(0), list.get(1), pointMin, pointMax);

			case Square:
				return new Square(list.get(0), pointMin, pointMax);

			case Triangle:
				Point point = new Point(0.0, 0.0);
				return new Triangle(list.get(0), point, pointMin, pointMax);
		default:
			break;
				
		}
	}

}
