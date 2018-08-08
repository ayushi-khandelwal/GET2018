package ds_Assignment_4.StringIntoUniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountUniqueCharsTest {

    CountUniqueChars stringObject = new CountUniqueChars();

    @Test
    public void test_WhenSingleStringContainsBothUniqueAndRepeatedCharacters_ReturnUniqueCharacters() {
        assertEquals(1, stringObject.countUniqueChars("abcdabcee"));
    }

    @Test
    public void test_WhenSingleStringContainsOnlyRepeatedCharacters_ReturnZero() {
        assertEquals(0, stringObject.countUniqueChars("eeedd"));
    }
    
    @Test
    public void test_countUniqueChars_WhenStringIsPassed_ReturnNumberOfUniqueCharacters() {
        assertEquals(2, stringObject.countUniqueChars("This is the pen"));
        assertEquals(4, stringObject.countUniqueChars("My name is Ayushi"));
    }

    @Test
    public void test_countUniqueChars_WhenStringHavingOnlyTwoTokensWhichAreSame_ReturnOne_BecauseSpaceBetweenTokens() {
        assertEquals(1, stringObject.countUniqueChars("THIS this"));
    }

    @Test
    public void test_When_unique_StringIsFrequentlyCalled_ReturnNumberOfUniqueCharactersUsingCache() {
        assertEquals(5, stringObject.countUniqueChars("This name is unique"));
        assertEquals(4, stringObject.countUniqueChars("unique"));
        assertEquals(4, stringObject.countUniqueChars("name"));
    }
}
