/**
 * @author Ayushi Khandelwal
 *
 */
public class MathProblem {
	
	int temp1 = 2;	//temporary variable temp1
	int lcm = 1;
	int LCM(int x, int y) {

			if(x == 1 && y == 1)	
				return lcm;
			
			if(x == 0 || y ==0) 
				return 0;
			
			else if(x%temp1 == 0 && y%temp1 == 0) {	//if both numbers x and y are completely divide by temp1
				x /= temp1;
				y /= temp1;
				lcm *= temp1;
				LCM(x, y);
			}
			
			else if(x%temp1 == 0) {	//if only x is able to completely divide by temp1
				x /= temp1;
				lcm *= temp1;
				LCM(x, y);
			}
			
			else if(y%temp1 == 0) {	//if only x is able to completely divide by temp2
				y /= temp1;
				lcm *= temp1;
				LCM(x, y);
			}
			
			else {	//if both x and y are not able to divide by temp1
				temp1++;
				LCM(x, y);
			}
		return lcm;
	}
	

	int hcf = 1;
	int temp2 = 2;	//temporary variable temp2
	int HCF(int x, int y) {
		int min = Math.min(x, y);
		while(temp2 <= Math.max(x, y)) {
			if((x == 1 && y ==1) || min == 1) 
				return hcf;
			
			if(x == 0 || y == 0) 
				return Math.max(x, y);
			
			if(x%temp2 == 0 && y%temp2 == 0) {	//if both numbers x and y are completely divide by temp2
				x /= temp2;	
				y /= temp2;
				hcf *= temp2;
				HCF(x, y);
			}
			else {	//if both x and y are not able to divide by temp2
				temp2++;
				HCF(x, y);
			}
		}
		
		return hcf;
	}
	
	
}
