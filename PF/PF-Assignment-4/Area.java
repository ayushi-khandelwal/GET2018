import java.util.*;
class Triangle	//implementing method to compute area
{
	double widthTriangle, heightTriangle;
	public double triangleArea(double widthTriangle, double heightTriangle) {	//Assuming width and height will be greater than zero
		this.widthTriangle = widthTriangle;
		this.heightTriangle = heightTriangle;
		double area = 0.0;
		
		try{
			area = 0.5 * widthTriangle * heightTriangle;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		
		return area;
	}
}

class Rectangle	//implementing method to compute area
{
	double widthRectangle, heightRectangle;
	public double rectangleArea(double widthRectangle, double heightRectangle){	//Assuming width and height will be greater than zero
		this.widthRectangle = widthRectangle;
		this.heightRectangle = heightRectangle;
		double area = 0.0;
		
		try{
			area = widthRectangle * heightRectangle;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		
		return area;
	}
}

class Square	//implementing method to compute area
{
	double widthSquare;
	public double squareArea(double widthSquare){	//Assuming width will be greater than zero
		this.widthSquare = widthSquare;
		double area = 0.0;
		
		try{
			area = widthSquare * widthSquare;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		return area;
	}
}

class Circle	//implementing method to compute area
{
	double radiusCircle;
	public double circleArea(double radiusCircle){	//Assuming radius will be greater than zero
		this.radiusCircle = radiusCircle;
		double area = 0.0;
		
		try{
			area = 3.14 * radiusCircle * radiusCircle;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		return area;
	}
}

public class Area
{
	public static void main(String args[])
	{
		Triangle triangle = new Triangle();
		Rectangle rectangle = new Rectangle();
		Square square = new Square();
		Circle circle = new Circle();
		Scanner scan = new Scanner(System.in);
		char continu = 'a';
		int choice;
		
		do{
			System.out.println("Menu to find Area of different shapes!!");
			System.out.println("1.Triangle");
			System.out.println("2.Rectangle");
			System.out.println("3.Square");
			System.out.println("4.circle");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.nextInt();
			
			switch(choice)
			{
				case 1: 
					System.out.print("Enter width of triangle : "); 
					double widthTriangle = scan.nextDouble();
					System.out.print("Enter height of triangle : "); 
					double heightTriangle = scan.nextDouble();
					
					if(widthTriangle<0 || heightTriangle<0){
						System.out.println("Invalid input");
						break;
					}
					
					System.out.println("Area of triangle is " + triangle.triangleArea(widthTriangle, heightTriangle));
					break;
						
				case 2: 
					System.out.print("Enter width of rectangle : "); 
					double widthRectangle = scan.nextDouble();
					System.out.print("Enter height of rectangle : "); 
					double heightRectangle = scan.nextDouble();
					
					if(widthRectangle<0 || heightRectangle<0){
						System.out.println("Invalid input");
						break;
					}
					
					System.out.println("Area of rectangle is " + rectangle.rectangleArea(widthRectangle, heightRectangle));
					break;
						
				case 3: 
					System.out.print("Enter width of square : "); 
					double widthSquare = scan.nextDouble();
					
					if(widthSquare<0){
						System.out.println("Invalid input");
						break;
					}
					
					System.out.println("Area of square is " + square.squareArea(widthSquare));
					break;
						
				case 4:	
					System.out.print("Enter radius of circle : "); 
					double radiusCircle = scan.nextDouble();
					
					if(radiusCircle<0){
						System.out.println("Invalid input");
						break;
					}
					
					System.out.println("Area of circle is " + circle.circleArea(radiusCircle));
					break;
						
				case 5: 
					System.exit(0);
				
				default: System.out.print("Invalid input"); break;
			}
			System.out.print("\nDo you want to continue? (Y/N): ");
			continu = scan.next().charAt(0);
			System.out.println("");
		}while(continu=='Y' || continu=='y');
	}	
}
