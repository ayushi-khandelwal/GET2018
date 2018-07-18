import java.util.Scanner;
public class JobScheduler
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of processes : ");
		int noOfProcess = scan.nextInt();
		int arrivalTime[] = new int[noOfProcess];
		int burstTime[] = new int[noOfProcess];
		int completionTime[] = new int[noOfProcess];
		int turnAroundTime[] = new int[noOfProcess];
		int waitingTime[] = new int[noOfProcess];
		int totalWaitingTime = 0;
		int avgWaitingTime = 0;

		System.out.println("\nAVERAGE TIME");
		for(int i=0 ; i<noOfProcess ; i++)	
		{
			System.out.print("Enter arrival time of process " + (i+1) + " : ");
			arrivalTime[i] = scan.nextInt();
		}

		System.out.println("\nBURST TIME");	
		for(int i=0 ; i<noOfProcess ; i++)
		{
			System.out.print("Enter burst time of process " + (i+1) + " : ");
			burstTime[i] = scan.nextInt();
		}
		
		System.out.println("\nCOMPLETION TIME :-");
		for(int i=0 ; i<noOfProcess ; i++)	//computing completion time
		{
			if(i==0)
			{
				completionTime[i] = arrivalTime[i] + burstTime[i];
				System.out.println("The completion time for process " + (i+1) + " is " + completionTime[i]);
			}
			else
			{
				 if(arrivalTime[i] > completionTime[i-1])
				 {
				 	completionTime[i] = arrivalTime[i] + burstTime[i];
					System.out.println("The completion time for process " + (i+1) + " is " + completionTime[i]);
				 }
				 else
				 {
				 	completionTime[i] = completionTime[i-1] + burstTime[i];
					System.out.println("The completion time for process " + (i+1) + " is " + completionTime[i]);
				 }		
			}
		}
		
		System.out.println("\nTURN AROUND TIME :-");	
		for(int i=0 ; i<noOfProcess ; i++)
		{
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
			System.out.println("The turn around time for process " + (i+1) + " is " + turnAroundTime[i]);
		}
		
		System.out.println("\nWAITING TIME :-");	
		for(int i=0 ; i<noOfProcess ; i++)
		{
			waitingTime[i] = turnAroundTime[i] - burstTime[i];
			System.out.println ("The waiting time for process " + (i+1) + " is " + waitingTime[i]);
			totalWaitingTime += waitingTime[i];
		}
		avgWaitingTime = totalWaitingTime / noOfProcess;
		System.out.println("\nThe average waiting time is " + avgWaitingTime);
	}
}