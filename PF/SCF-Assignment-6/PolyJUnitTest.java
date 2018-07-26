import static org.junit.Assert.*;
import org.junit.Test;

public class PolyJUnitTest {
   Poly poly1 = new Poly(new int[]{4, 2, 1, 2});

   @Test
   public void test_Evaluate_WhenValueIsPositive_ThenReturnCorrectOutput() {
       assertEquals(28.0, poly1.evaluate(2.0F), 0.001);
   }

   @Test
   public void test_Evaluate_WhenValueIsNegative_ThenReturnInvalidOutput() {
       assertEquals(-1, poly1.evaluate(-10), 0.001);
   }

   @Test
   public void test_Degree() {
       assertEquals(4, poly1.degree());
   }

   @Test
   public void test_AddPoly_ReturnCorrectOuput() {
       Poly poly2 = new Poly(new int[]{3, 5, 4});
       assertArrayEquals(new int[]{7, 7, 5, 2}, poly1.addPoly(poly1, poly2));
   }

   @Test
   public void test_AddPoly_WhenSecondPolyIsPassedEmpty_ThenReturnFirstPoly() {
       Poly poly2 = new Poly(new int[]{ });
       assertArrayEquals(new int[]{4, 2, 1, 2}, poly1.addPoly(poly1, poly2));
   }

   @Test
   public void test_AddPoly_WhenSecondPolyHasNegativeValues_ThenReturnCorrectOutput() {
       Poly poly2 = new Poly(new int[]{-1, 2});
       assertArrayEquals(new int[]{3, 4, 1, 2}, poly1.addPoly(poly1, poly2));
   }

   
   @Test
   public void test_MultiplyPoly_WhenPositiveElementPassed_ReturnCorrectOutput() {
       Poly poly2 = new Poly(new int[]{2, 1, 3});
       assertArrayEquals(new int[]{8, 8, 16, 11, 5, 6}, poly1.multiplyPoly(poly1, poly2));
      
   }
   
   @Test
   public void test_MultiplyPoly_WhenNegativeElementPassed_ReturnCorrectOutput() {
	   Poly poly2 = new Poly(new int[]{1, -3});
	   assertArrayEquals(new int[]{4, -10, -5, -1, -6 }, poly1.multiplyPoly(poly1, poly2));
      
   }
   
   @Test
   public void testMultiplyPoly_WhenEmptyPolyIsPassed_ReturnZero() {
       Poly poly2 = new Poly(new int[]{ });
       assertArrayEquals(new int[]{0, 0, 0 }, poly1.multiplyPoly(poly1, poly2));
   }
}