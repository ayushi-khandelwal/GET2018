import java.util.*;
class Triangle	//implementing method to compute area
{
	double width, height;
	public double area(double width, double height) {	//Assuming width and height will be greater than zero
		this.width = width;
		this.height = height;
		double area=0.0;
		try{
			area = 0.5 * width * height;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		return area;
	}
}

class Rectangle	//implementing method to compute area
{
	double width, height;
	public double area(double width, double height){	//Assuming width and height will be greater than zero
		this.width = width;
		this.height = height;
		double area = 0.0;
		try{
			area = width * height;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		return area;
	}
}

class Square	//implementing method to compute area
{
	double width;
	public double area(double width){	//Assuming width will be greater than zero
		this.width = width;
		double area = 0.0;
		try{
			area = width * width;
		}
		catch(ArithmeticException e){
			System.out.println("Invalid input");
		}
		return area;
	}
}

class Circle	//implementing method to compute area
{
	double radius;
	public double area(double radius){	//Assuming radius will be greater than zero
		this.radius = radius;
		double area = 0.0;
		try{
			area = 3.14 * radius * radius;
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
		
		while(true){
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
					double width = scan.nextDouble();
					while(width < 0){
						System.out.println("Width should be positive!!");
						System.out.print("Enter width of triangle : ");
						width = scan.nextDouble();
					}
					
					System.out.print("Enter height of triangle : "); 
					double height = scan.nextDouble();
					while(height < 0){
						System.out.println("Height should be positive!!");
						System.out.print("Enter height of triangle : "); 
						height = scan.nextDouble();
					}
					
					System.out.println("Area of triangle is " + triangle.area(width, height));
					break;
						
				case 2: 
					System.out.print("Enter width of rectangle : "); 
					double widthRectangle = scan.nextDouble();
					while(widthRectangle < 0){
						System.out.println("Width should be positive!!");
					System.out.print("Enter width of rectangle : ");
						widthRectangle = scan.nextDouble();
					}
					
					System.out.print("Enter height of rectangle : "); 
					double heightRectangle = scan.nextDouble();
					while(heightRectangle < 0){
						System.out.println("Height should be positive!!");
						System.out.print("Enter height of rectangle : ");
						heightRectangle = scan.nextDouble();
					}
					
					System.out.println("Area of rectangle is " + rectangle.area(widthRectangle, heightRectangle));
					break;
						
				case 3: 
					System.out.print("Enter width of square : "); 
					double widthSquare = scan.nextDouble();
					
					while(widthSquare < 0){
						System.out.println("Width should be positive!!");
						System.out.print("Enter width of square : "); 
						widthSquare = scan.nextDouble();
					}
					
					System.out.println("Area of square is " + square.area(widthSquare));
					break;
						
				case 4:	
					System.out.print("Enter radius of circle : "); 
					double radiusCircle = scan.nextDouble();
					
					while(radiusCircle < 0){
						System.out.println("Radius should be positive!!");
						System.out.print("Enter radius of circle : "); 
						radiusCircle = scan.nextDouble();
					}
					
					System.out.println("Area of circle is " + circle.area(radiusCircle));
					break;
						
				case 5: System.exit(0);
				
				default: System.out.print("Invalid input"); break;
			}
			System.out.print("Enter any character to continue : ");
			scan.next();
			System.out.println("");
		}
	}
}
