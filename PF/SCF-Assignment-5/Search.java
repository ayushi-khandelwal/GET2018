
public class Search {
	
	int linearSearch(int arr[], int element, int index) {
		
		if(index > arr.length)
			return -1;
		
		if(arr.length == 0){	//checks if array is empty
			throw new AssertionError();
		}
		
		if(arr[index] == element)
			return index;
	
		return linearSearch(arr, element, index+1);
	}
	
	int binarySearch(int arr[], int element, int startIndex, int endIndex) {
		if(arr.length == 0)
			return -1;
		if(startIndex <= endIndex) {
			int mid = ((startIndex + endIndex)/2);
			
			if(element == arr[mid])
				return mid;
			
			else if(element < arr[mid])
				return binarySearch(arr, element, startIndex, mid-1);
			
			else if(element > arr[mid])
				return binarySearch(arr, element, (mid+1), endIndex);
		}
		return -1;
	}
}
