import static org.junit.Assert.*;

import org.junit.Test;

public class SearchJUnitTest {

	Search search = new Search();
	
	@Test
	public void LinearSearchTestFirst() {
		assertEquals(3, search.linearSearch(new int[] {1, 9, 8, 6, 4, 3, 2}, 6, 0));
	}
	
	@Test
	public void LinearSearchTestSecond() {
		assertEquals(0, search.linearSearch(new int[] {1, 5, 6, 8}, 1, 0));
	}

	@Test
	public void LinearSearchTestThird() {
		assertEquals(1, search.linearSearch(new int[] {0, 1 , 2}, 1, 0));
	}

	@Test(expected = AssertionError.class)
	public void LinearSearchTestFourth() {
		assertEquals(-1, search.linearSearch(new int[] {}, 6, 0));
	}


	@Test
	public void BinarySearchTestFirst() {
		assertEquals(3, search.binarySearch(new int[] {1, 2, 5, 6, 8, 9, 12}, 6, 0, 6));
	}
	
	@Test
	public void BinarySearchTestSecond() {
		assertEquals(3, search.binarySearch(new int[] {1, 2, 6, 8}, 8, 0, 3));
	}

  	@Test
	
	public void BinarySearchTestThird() {
		assertEquals(0, search.binarySearch(new int[] {0, 1 , 2}, 0, 0, 2));
	}

	@Test
	public void BinarySearchTestFourth() {
		assertEquals(-1, search.binarySearch(new int[] {}, 6, 0, 0));
	}

	
	
}
