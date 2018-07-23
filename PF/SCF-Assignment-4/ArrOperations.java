/**
 * @author Ayushi Khandelwal
 *
 */
public class ArrOperations 
{
	int largestMirror(int enteredArray[]) {	//Return the size of the largest mirror section found in the input array
		
		int size = enteredArray.length;
		
		if(size == 0) {throw new AssertionError();}
			
		int mirror = 1, currentMirror = 1;
		
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j >= 0; j--) {
				
				if (enteredArray[i] == enteredArray[j]) {
					int index = i + 1, trace = j - 1;
					currentMirror = 1;
					
					while (index < size && trace >=0 ) {
						
						if (enteredArray[index] == enteredArray[trace]) {
							currentMirror++;
							index++;
							trace--;
						} else {
							break;
						}
						
						if (currentMirror > mirror) 
							mirror = currentMirror;
					}
				}
			}
		}
		return mirror;
	}
	
	int countClumps(int arr[])	//Return the number of clumps in the input array.
	{
		int max = arr.length;
		
		if(max == 0) {throw new AssertionError();}
		
		int count = 0;	//number of clumps are initialize to zero
		
		for(int i = 0;  ; i++) {
			if(i < max-2) {
				if(arr[i] != arr[i+2]) {	//checks if same arr[i] and arr[i+2] are equal 
												//then clump is not counted yet
					if(arr[i] == arr[i+1]){
						count++;	//number of clumps increases
					}
				}
			}
			if(i == max-2) {	
				if(arr[i] == arr[i+1]) {
					count++;
					return count;
				}
			}
			if(i == max-1) {
				return 0;
			}
		}
	}
	
	int[] fixXY(int arr[], int x, int y)	//Solve fixXY problem
	{
		int max = arr.length;
		
		//handle exception if array is empty and if X occurs at the last index of array
		if(max == 0 || arr[max-1] == x) {throw new AssertionError();}
		
		//handle exception if there are unequal numbers of X and Y in input array
		int countX = 0, countY = 0;
		for(int i=0 ; i<max ; i++) {
			if(arr[i] == x) {
				countX++;
			}
			if(arr[i] == y) {
				countY++;
			}
		}
		if(countX != countY) {
			throw new AssertionError();
		}
		
		//handle exception if two adjacent X values are there
		for(int i=0 ; i<max-1 ; i++) {
			if(arr[i] == x && arr[i+1] == x) {
				throw new AssertionError();
			}
		}
		
		for(int i = 0; i < max-2; i++) {
			if(arr[i] == x && arr[i+1] != y) {
				for(int j = 0; j < max; j++) {
					if(j == 0) {
						if(arr[j] != x && arr[j] == y) {
							int temp = arr[i+1];
							arr[i+1] = arr[j];
							arr[j] = temp;
						}
					}
					if(j > 0 && j < max) {
						if(arr[j] != x && arr[j] == y && arr[j-1] != x) {
							int temp = arr[i+1];
							arr[i+1] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
		}
		return arr;
	}
	
	int splitArray(int arr[])	//Return the number of clumps in the input array.
	{
		int size = arr.length;
	
		if(size == 0) {throw new AssertionError();}
		
		int sumFirst = 0;
		int sumLast = 0;
		int index = size;
		for(int i = 0; i < size-1; i++){	
			sumFirst += arr[i];	//putting sum of all the values except last in sumFirst
			index = i;
		}
		sumLast = arr[index+1];	//putting last value of array in sumLast
		
		while(sumFirst >= sumLast){
			if(sumFirst == sumLast)	
				return index;
			else{
				sumFirst -= arr[index];	//deleting values from the end
				sumLast += arr[index];	//adding those values in sumFirst
				index--;
			}
		}
		return -1;
	}
}

