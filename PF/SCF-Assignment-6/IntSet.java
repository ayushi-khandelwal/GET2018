
/**
 * @author Ayushi Khandelwal
 *
 */
final class IntSet {
	
	private int[] array = new int[1000];	//setting array range
	
	public IntSet(int[] array){	//parameterized constructor
		this.setArray(array);
	}

	public int[] getArray() {	//getter
		return array;
	}

	public void setArray(int[] array) {	//setter
		this.array = array;
	}
	
	/**
	 * @return true if array is empty, else return false
	 */
	public boolean isEmpty() {	//checks if array is empty or not
		try{
			if(array.length == 0) {
				throw new AssertionError();	//if empty, throw Assertion Error
			}
		}
		catch(AssertionError e){
			e.printStackTrace();	//print on console what error is being catched
			return true;
		}
		return false;
	}
	
	/**
	 * @param element
	 * @return true if element is a member of an array or not
	 */
	public boolean isMember(int element){	//check if member is present in array or not
		if(element < 1 || element > 1000 || isEmpty())	//if element is out of its range or array is empty, then return false
			return false;
		
		for(int i = 0; i < array.length; i++){
			if(array[i] == element)		
				return true;
		}
		
		return false;
	}
	
	/**
	 * @return size of an array
	 */
	public int size(){
		if(array.length > 1000)	//if array goes out of range
			return -1;
		
		return array.length;
	}
	
	/**
	 * @param s
	 * @return boolean value if subset s is present in an array or not  
	 */
	public boolean isSubSet(IntSet s){
		if(!(s.isEmpty()))	
			if(!(isMember(s.array[0])))	//check whether subset is a member of array or not
				return false;
					
		return true;
	}
	
	/**
	 * @return integer array after doing complement of given array
	 */
	public int[] getCompliment() {	
		if(array.length > 1000)
			throw new AssertionError();
		
		int[] tempArray = new int[1000 - array.length];	//making temporary array used only in this function
		int count = 0;
		for(int i = 1; i <= 1000; i++) {
			if(!isMember(i))
					tempArray[count++] = i;	
		}
		return tempArray;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return integer array after performing union operation on subset s1 and s2
	 */
	public int[] union(IntSet s1, IntSet s2) {
		int[] tempArray = new int[s1.array.length + s2.array.length];
		boolean flag = false;
		int count = 0;
		for(int itr = 0; itr < s1.array.length; itr++) {
			for(int j = 0; j < s2.array.length; j++) {
				if(s1.array[itr] == s2.array[j]) {	//if set s1 has value same as in set s2, 
													//then set flag to false
					flag = false;
					break;
				}
				else
					flag = true;	//else if set s1 has value other than in set s2, 
									//then set flag to true
			}
			if(flag == true) {	
				tempArray[count++] = s1.array[itr];	
			}
		}
		for(int j = 0; j < s2.array.length; j++)
			tempArray[count++] = s2.array[j];	//complete set s2 will insert in tempArray
	
		return tempArray;
	}
}
