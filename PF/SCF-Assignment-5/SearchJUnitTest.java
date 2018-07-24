import static org.junit.Assert.*;
import org.junit.Test;

public class SearchJUnitTest {
	Search search = new Search();
	
	@Test
	public void test_LinearSearch_WouldReturnCorrectOutput() {
		assertEquals(3, search.linearSearch(new int[] {1, 9, 8, 6, 4, 3, 2}, 6, 0));
	}

	@Test
	public void test_LinearSearch_WhenRepeatedElementsArePassed_ThenReturnsFirstIndexOfElement() {
		assertEquals(1, search.linearSearch(new int[] {0, 1 ,1, 2}, 1, 0));
	}

	@Test(expected = AssertionError.class)
	public void test_LinearSearch_WhenArrayIsEmpty_ReturnsAssertionError() {
		assertEquals(-1, search.linearSearch(new int[] {}, 6, 0));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test_LinearSearch_WhenElementNotFound_ReturnsArrayIndexOutOfBoundsException() {
		assertEquals(-1, search.linearSearch(new int[] {1,2,3}, 6, 0));
	}


	@Test
	public void test_BinarySearch_WouldReturnCorrectOutput() {
		assertEquals(3, search.binarySearch(new int[] {1, 2, 5, 6, 8, 9, 12}, 6, 0, 6));
	}
	
	@Test
	public void test_BinarySearch_WhenElementNotFound_ReturnsArrayIndexOutOfBoundsException() {
		assertNotEquals(3, search.binarySearch(new int[] {1, 2, 6, 8}, 3, 0, 3));
	}


	@Test
	public void test_BinarySearch_WhenRepeatedElementsArePassed_ThenReturnsFirstIndexOfElement() {
		assertNotEquals(3, search.binarySearch(new int[] {1, 2, 2, 6, 8}, 2, 0, 3));
	}

	@Test
	public void test_BinarySearch_WhenArrayIsEmpty_ReturnsAssertionError() {
		assertEquals(-1, search.binarySearch(new int[] {}, 6, 0, 0));
	}
}
