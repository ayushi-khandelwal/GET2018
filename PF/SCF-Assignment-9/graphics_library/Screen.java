package SCF_Assignment_9.graphics_library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import SCF_Assignment_9.graphics_library.Shapes.Shape;

public class Screen {
	List<ScreenObject> screenObjects;
	
	public Screen(){
		screenObjects = new ArrayList<>();
	}
	
		/**
		 * Adds a shape to the screen
		 * @param shapeType
		 * @param point
		 * @param parameters
		 * @throws Exception 
		 */
		public void addShape(ShapeType shapeType, Point point, List<Integer> parameters) throws Exception{
			screenObjects.add(new ScreenObject(ShapeFactory.createShape(shapeType, point, parameters)));
		}
		Iterator<ScreenObject> screenObjectIterator = screenObjects.iterator();
		while (screenObjectIterator.hasNext()){
			Shape shape = screenObjectIterator.next().getShape(); 
			if (shape.equals(shapeToRemove)){
				screenObjectIterator.remove();
				return;
			}
		}
		throw new Exception("No such shape found");
	}
	
	/**
	 * Remove a shape from screen  
	 * @param ShapeType shape type
	 */
	public void removeShape(ShapeType shapeType){
		Iterator<ScreenObject> screenObjectIterator = screenObjects.iterator();
		while (screenObjectIterator.hasNext()){
			ScreenObject screenObject = screenObjectIterator.next(); 
			if (screenObject.getShape().getShapeType().equals(shapeType))
				screenObjectIterator.remove();
		}
	}
	
	public List<Shape> shapesEnclosing(Point point){
		List<Shape> shapes = new ArrayList<Shape>();
		for (ScreenObject screenObject: screenObjects){
			if (screenObject.getShape().isPointEnclosed(point))
				shapes.add(screenObject.getShape());
		}
		return shapes;
	}
	
	public List<Shape> getSortedShapes(){
		List<Shape> shapes = new ArrayList<Shape>();
		for (ScreenObject screenObject: screenObjects)
			shapes.add(screenObject.getShape());
		
		Collections.sort(shapes, Comparator<>);
		return shapes;
	}
}
			}
		}
}
