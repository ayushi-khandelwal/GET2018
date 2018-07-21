import java.util.*;
class MarksheetMethods	
{
	int noOfStudents;
	public double averageGrade(int students, double grades[]) {	//return average grade of the class
		noOfStudents = students;
		double totalGrade = 0;
		for (int i = 0; i < noOfStudents; i++) {
			totalGrade = totalGrade + grades[i];
		}
		return (double)(totalGrade / noOfStudents);
	}
	
	public double maxGrade(int students, double grades[]) {	//returns maximum grade in class
		noOfStudents = students;
		double maxGrade = grades[0];
		for (int i = 0; i < noOfStudents; i++) {
			if (maxGrade < grades[i]) {
				maxGrade = grades[i];
			}
		}
		return maxGrade;
	}
	
	public double minGrade(int students, double grades[]) {	//returns minimum grade in class
		noOfStudents = students;
		double minGrade = grades[0];
		for (int i = 0; i < noOfStudents; i++) {
			if (minGrade > grades[i]) {
				minGrade = grades[i];
			}
		}
		return minGrade;
	}
	
	public double studentPassed(int students, double grades[]) {	//returns percentage of student passed in class
		noOfStudents = students;
		int noOfPassedStudents = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (grades[i] >= 40) {
				noOfPassedStudents++;
			}
		}
		return Math.round((double)noOfPassedStudents / noOfStudents * 100);
	}
}

public class Marksheet
{
	public static void main(String args[])
	{
		MarksheetMethods marksheetMethods = new MarksheetMethods();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int noOfStudents = scan.nextInt();
		double grade[] = new double[noOfStudents];
		
		System.out.println("Enter grades between 0 to 100:- ");
		for(int i=0 ; i<noOfStudents ; i++){
			System.out.print("Enter grade of student " + (i+1) + " : ");
			grade[i] = scan.nextInt();
			while (grade[i] > 100 || grade[i] < 0) {
				System.out.println("\nEntered grades should only be from 0 to 100");
				System.out.print("Enter grade of student " + (i+1) + " : ");
				grade[i] = scan.nextInt();
			}
		}
		
		int choiceOfOperation;
		while (true) {
			System.out.print("\nEnter the operation you want to perform\n1.Average of Grades\n2.Maximum of Grades\n3.Minimum of Grades\n4.Percent of Students Passed\n5.Exit\nEnter your choice : ");
			choiceOfOperation = scan.nextInt();
			
			switch (choiceOfOperation) {
			case 1: 
				System.out.println("Average grade is " + marksheetMethods.averageGrade(noOfStudents, grade));
				 break;
				
			case 2: 
				System.out.println("Maximum grade is " + marksheetMethods.maxGrade(noOfStudents, grade));
				break;
				
			case 3: 
				System.out.println("Minimum grade is " + marksheetMethods.minGrade(noOfStudents, grade));
				break;
			
			case 4:	
				System.out.println("Percentage of student passed is " + marksheetMethods.studentPassed(noOfStudents, grade) + "%");
				break;

			case 5 :
				System.exit(1);
			
			default: 
				System.out.println("Wrong Input");
			}
			
			System.out.print("Enter any character to continue : ");
			scan.next();
		}
	}
}
