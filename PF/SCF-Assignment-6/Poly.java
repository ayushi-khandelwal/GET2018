/**
 * @author Ayushi Khandelwal
 *
 */
public final class Poly {
	final private int[] polynomial;
	final private int noOfTerms;
	
		   /**
	 * @param powers
	 */
	public Poly(int[] powers) {	//Parameterized constructor gets coefficients of polynomial
		   noOfTerms = powers.length;
		   polynomial = new int[noOfTerms];
		
		   for (int i = 0; i < noOfTerms; i++) {
		       polynomial[i] = powers[i];
		   }
	}
	
	   /**
	 * @param valueOfVariable
	 * @return result after evaluating polynomial
	 */
	public float evaluate(float valueOfVariable) {	//gives result after evaluating polynomial
		   if(!(valueOfVariable < 0)){
			   float totalValue = 0.0F;
	
		       for (int i = 0; i < noOfTerms; i++) {
		           totalValue += ((float) (Math.pow(valueOfVariable, i)) * polynomial[i]);
		       }
		       return totalValue;
		   }
	      return -1;
	 }
	
	   /**
	 * @return degree of polynomial
	 */
	public int degree() {	//return highest power of polynomial
		   return noOfTerms;
	}
	
		   /**
	 * @param poly1
	 * @param poly2
	 * @return addition of two polynomials poly1 and poly2
	 */
	public int[] addPoly(Poly poly1, Poly poly2) {	//adds two polynomials poly1 and poly2
	   int[] sum = new int[Math.max(poly1.noOfTerms, poly2.noOfTerms)];
	
	   for (int i = 0; i < sum.length; i++) {
	       if (i < poly1.noOfTerms && i < poly2.noOfTerms) {	//if poly1 and poly2 has same number of terms
	    	   sum[i] = poly1.polynomial[i] + poly2.polynomial[i];
	       } 
	       else {
	    	   if (poly1.noOfTerms < poly2.noOfTerms) {	//if poly2 has more number of terms than poly1
	    		   sum[i] = poly2.polynomial[i];
	    	   } 
	    	   else {
	    		   sum[i] = poly1.polynomial[i];	//if poly1 has more number of terms than poly2
	    	   }
	       }
       }
       return sum;
   }
	
		/**
	 * @param poly1
	 * @param poly2
	 * @return multiplication of two polynomials poly1 and poly2
	 */
	public int[] multiplyPoly(Poly poly1, Poly poly2) {	//multiply two polynomials poly1 and poly2
	   int[] product = new int[poly1.noOfTerms + poly2.noOfTerms - 1];
	
	   for (int i = 0; i < poly1.noOfTerms; i++) {
	       for (int j = 0; j < poly2.noOfTerms; j++) {
	           product[i + j] += poly1.polynomial[i] * poly2.polynomial[j];	
	       }
	   }
	  /* for(int i = 0; i < product.length - 1; i++)		//to print integer array after multiplying two polynomials
		   System.out.print("(" + product[i] + "x ^ " + i + ")" + " + ");
	   System.out.print("(" + product[product.length-1] + "x ^ " + (product.length-1) + ")");
	   System.out.print("\n\n");
	   */
	       return product;
   }
}