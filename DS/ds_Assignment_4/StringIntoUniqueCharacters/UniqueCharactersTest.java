package ds_Assignment_4.StringIntoUniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharactersTest {

    UniqueCharacters stringObject = new UniqueCharacters();

    @Test
    public void test_WhenSingleStringContainsBothUniqueAndRepeatedCharacters_ReturnUniqueCharacters() {
        assertEquals(1, stringObject.countUniqueCharacters("abcdabcee"));
    }

    @Test
    public void test_WhenSingleStringContainsOnlyRepeatedCharacters_ReturnZero() {
        assertEquals(0, stringObject.countUniqueCharacters("eeedd"));
    }
    
    @Test
    public void test_countUniqueCharacters_WhenStringIsPassed_ReturnNumberOfUniqueCharacters() {
        assertEquals(2, stringObject.countUniqueCharacters("This is the pen"));
        assertEquals(4, stringObject.countUniqueCharacters("My name is Ayushi"));
    }

    @Test
    public void test_countUniqueCharacters_WhenStringHavingOnlyTwoTokensWhichAreSame_ReturnOne_BecauseSpaceBetweenTokens() {
        assertEquals(1, stringObject.countUniqueCharacters("THIS this"));
    }

    @Test
    public void test_When_unique_StringIsFrequentlyCalled_ReturnNumberOfUniqueCharactersUsingCache() {
        assertEquals(5, stringObject.countUniqueCharacters("This name is unique"));
        assertEquals(4, stringObject.countUniqueCharacters("unique"));
        assertEquals(4, stringObject.countUniqueCharacters("name"));
    }
}