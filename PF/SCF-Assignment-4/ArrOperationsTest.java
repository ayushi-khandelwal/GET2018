import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationsTest {
	ArrOperations arrOperations = new ArrOperations();
	
	@Test
	public void testMirrorFirst() {
		int count = arrOperations.largestMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 });
		assertEquals(3, count);
	}
	
	@Test
	public void testMirrorSecond() {
		int count = arrOperations.largestMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 });
		assertEquals(2, count);
	}

	@Test
	public void testMirrorThird() {
		int count = arrOperations.largestMirror(new int[] {1, 2, 1, 4 });
		assertEquals(3, count);
	}
	
	@Test
	public void testMirrorFourth() {
		int count = arrOperations.largestMirror(new int[] {1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, count);
	}
	
	@Test(expected = AssertionError.class)
	public void testMirrorFifth() {
		int count = arrOperations.largestMirror(new int[] { });
		assertEquals(-1, count);
	}
	
	
	@Test
	public void testCountFirst() {
		int count = arrOperations.countClumps(new int[] { 1, 2, 2, 3, 4, 4 });
		assertEquals(2, count);
	}
	
	@Test
	public void testCountSecond() {
		int count = arrOperations.countClumps(new int[] { 1, 1, 2, 1, 1 });
		assertEquals(2, count);
	}

	@Test
	public void testCountThird() {
		int count = arrOperations.countClumps(new int[] { 1, 1, 1, 1, 1 });
		assertEquals(1, count);
	}
	
	@Test(expected = AssertionError.class)
	public void testCountFourth() {
		int count = arrOperations.countClumps(new int[] { });
		assertEquals(-1, count);
	}
	
	
	@Test
	public void testFixFirst() {
		int[] arr  = arrOperations.fixXY(new int[] { 5, 4, 9, 4, 9, 5 }, 4 , 5 );
		assertArrayEquals(new int[] {9, 4, 5, 4, 5, 9}, arr);
	}
	
	@Test(expected = AssertionError.class)
	public void testFixSecond() {
		int[] arr = arrOperations.fixXY(new int[] { 1, 4, 5, 5 }, 4 , 5);
		assertArrayEquals(new int[] {1, 4, 5, 5}, arr);
	}

	@Test(expected = AssertionError.class)
	public void testFixThird() {
		int[] arr = arrOperations.fixXY(new int[] { 1, 4, 5, 5, 3, 4}, 4 , 5);
		assertArrayEquals(new int[] {1, 4, 5, 5, 3, 4}, arr);
	}

	@Test(expected = AssertionError.class)
	public void testFixFourth() {
		int[] arr = arrOperations.fixXY(new int[] { 1, 4, 4, 5}, 4 , 5);
		assertArrayEquals(new int[] {1, 4, 5, 5}, arr);
	}
	
	@Test
	public void testSplitFirst() {
		int index = arrOperations.splitArray(new int[] { 1, 1, 1, 2, 1 });
		assertEquals(2, index);
	}
	
	
	@Test
	public void testSplitSecond() {
		int index = arrOperations.splitArray(new int[] { 2, 1, 1, 2, 1 });
		assertEquals(-1, index);
	}

	@Test
	public void testSplitThird() {
		int index = arrOperations.splitArray(new int[] { 10, 10 });
		assertEquals(0, index);
	}

	@Test(expected = AssertionError.class)
	public void testSplitFourth() {
		int index = arrOperations.splitArray(new int[] { });
		assertEquals(-1, index);
	}
	
}
