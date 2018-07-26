import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntSetJUnitTest {
	
	int[] array = {9, 8, 7, 4, 5 ,6 , 3, 2, 1 };
	IntSet intSet = new IntSet(array );
	
	@Test
	public void test_IsMember_WhenMemberIsPresent_ReturnTrue() {
		assertEquals(true, intSet.isMember(3));
	}

	@Test
	public void test_IsMember_WhenMemberIsNotPresent_ReturnFalse() {
		assertEquals(false, intSet.isMember(10));
	}

	@Test
	public void test_IsMember_WhenMemberIsNegativeAndNotPresent_ReturnFalse() {
		assertEquals(false, intSet.isMember(-3));
	}

	@Test(expected = AssertionError.class)
	public void test_IsMember_WhenArrayIsEmpty_ThrowAssertionError() {
		assertEquals(false, intSet.isMember(3));
	}

	
	@Test
	public void test_Size_ReturnsTrue() {
		assertEquals(9, intSet.size());
	}

	@Test(expected = AssertionError.class)
	public void test_Size_WhenArrayIsEmpty_ThrowAssertionError() {
		assertEquals(false, intSet.size());
	}

	
	@Test(expected = NullPointerException.class)
	public void test_IsSubSet_WhenSubSetIsNull_ReturnFalse() {
		assertEquals(false, intSet.isSubSet(null));
	}

	@Test(expected = AssertionError.class)
	public void test_IsSubSet_WhenSubSetIsEmpty_ThrowAssertionError() {
		IntSet s = new IntSet(new int[] { });
		assertEquals(false, intSet.isSubSet(s));
	}

	@Test
	public void test_IsSubSet_WhenSubSetIsPresent_ReturnTrue() {
		IntSet s = new IntSet(new int[] { 5, 3, 9, 4});
		assertEquals(true, intSet.isSubSet(s));
	}
	
	@Test(expected = AssertionError.class)
	public void test_IsSubSet_WhenSubSetIsNotPresent_ReturnFalse() {
		IntSet s = new IntSet(new int[] {4, 2, 3, 10});
	assertEquals(false, intSet.isSubSet(s));
	}

	@Test
	public void test_GetCompliment() {	
		int[] tempArray = new int[1000 - array.length];	//temporary array used to check if the given elements are still 
														//present in the set after doing complement operation or not
		tempArray = intSet.getCompliment();	//tempArray contains complemented elements now
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < tempArray.length; j++) {
				if(array[i] == tempArray[j])	//checks whether any element in a given array is present in a complimented array or not
					assertEquals(false, intSet.getCompliment());
				
				if(j == tempArray.length)
					assertEquals(true, intSet.getCompliment());
			}
		}
	}

	@Test
	public void test_Union_WhenBothSetHaveSameValues_ReturnValidOutput() {
		IntSet subSetObj1 = new IntSet(new int[]{5, 8, 9});
		IntSet subSetObj2 = new IntSet(new int[]{1, 2, 4});
		assertArrayEquals(new int[]{5 , 8 , 9 , 1 , 2 , 4}, intSet.union(subSetObj1,subSetObj2));
	}

	@Test
	public void test_Union_WhenBothSetsHaveSameValues_ReturnValidOutput() {
		IntSet subSetObj1 = new IntSet(new int[]{5, 8});
		IntSet subSetObj2 = new IntSet(new int[]{5, 8});
		assertArrayEquals(new int[]{5, 8, 0, 0}, intSet.union(subSetObj1,subSetObj2));
	}

	@Test
	public void test_Union_WhenBothSetsHaveSameValue_ReturnValidOutput() {
		IntSet subSetObj1 = new IntSet(new int[]{});
		IntSet subSetObj2 = new IntSet(new int[]{1, 2, 8, 4});
		assertArrayEquals(new int[]{1, 2, 8, 4}, intSet.union(subSetObj1,subSetObj2));
	}
}
