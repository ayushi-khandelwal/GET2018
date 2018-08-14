package algorithm_assignment_1.dictionary;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class DictionaryUtilTest {
    
    @Test
    public void test_addWord_WhenKeyAndValueArePassed_ReturnTrue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals(true, dictionary.addWord("file", "used to store data"));
        assertEquals(true, dictionary.addWord("earphones", "used to listen music"));
        assertEquals(true, dictionary.addWord("book", "used to gain knowledge"));
    }

    @Test(expected = AssertionError.class)
    public void test_addWord_WhenKeyIsNotPassed_ThrowAssertionError() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Word cannot be null!!", dictionary.addWord("", "used to store data"));
    }

    @Test(expected = AssertionError.class)
    public void test_addWord_WhenValueIsNotPassed_ThrowAssertionError() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Meaning cannot be null!!", dictionary.addWord("file", ""));
    }

    @Test(expected = AssertionError.class)
    public void test_addWord_WhenValueIsPassedButJsonDataISNull_ThrowAssertionError() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryDataNull.json");
        assertEquals("Dictionary data can't be null", dictionary.addWord("file", ""));
    }
    
    @Test
    public void test_deleteWord_WhenKeyIsPassed_ReturnTrue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals(true, dictionary.deleteWord("peak"));
        assertEquals(true, dictionary.deleteWord("apple"));
    }

    @Test(expected = AssertionError.class)
    public void test_deleteWord_WhenKeyIsNotPassed_ReturnTrue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Word cannot be null!!", dictionary.deleteWord(""));
    }

    @Test(expected = AssertionError.class)
    public void test_deleteWord_WhenDeletedKeyIsPassed_ThrowAssertionError() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Peak does not exist", dictionary.deleteWord("peak"));
    }

    @Test(expected = AssertionError.class)
    public void test_deleteWord_WhenKeyIsPassedButJsonDataIsNull_ThrowAssertionError() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryDataNull.json");
        assertEquals("Dictionary data can't be null", dictionary.deleteWord("apple"));
    }
    
    @Test
    public void test_getMeaning_WhenKeyIsPassed_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("an animal", dictionary.getMeaning("tiger"));
    }

    @Test(expected = AssertionError.class)
    public void test_getMeaning_WhenKeyIsNotPassed_ReturnTrue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Word does not exist", dictionary.getMeaning(""));
    }

    @Test(expected = AssertionError.class)
    public void test_getMeaning_WhenKeyIsPassedButJsonDataIsNull_ReturnTrue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryDataNull.json");
        assertEquals("Dictionary data can't be null", dictionary.getMeaning(""));
    }
    
    @Test
    public void test_getSortedDictionary_WhenKeyIsPassed_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("[apple --> a fruit, "
                + "peak --> topmost point, "
                + "peek --> glance or a quick look, "
                + "pen --> used to write something, "
                + "pique --> to make someone angry or annoyed, "
                + "tiger --> an animal]", dictionary.getSortedDictionary());
    }

    @Test
    public void test_getSortedDictionary_WhenKeyIsNotPassed_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Data can't be null", dictionary.getSortedDictionary());
    }

    @Test
    public void test_getSortedDictionary_WhenKeyIsPassedButJsonDataIsNull_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryDataNull.json");
        assertEquals("Dictionary data can't be null", dictionary.getSortedDictionary());
    }

    @Test
    public void test_get_WhenKeyIsPassed_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("[peak --> topmost point, "
                + "peek --> glance or a quick look, "
                + "pen --> used to write something, "
                + "pique --> to make someone angry or annoyed]", dictionary.getSortedDictionaryInRange("peak", "pique"));
    }

    @Test
    public void test_getSortedDictionaryInRange_WhenKeyIsNotPassed_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryData.json");
        assertEquals("Data can't be null", dictionary.getSortedDictionaryInRange("", ""));
    }

    @Test
    public void test_getSortedDictionaryInRange_WhenKeyIsPassedButJsonDataIsNull_ReturnValue() {
        DictionaryUtil dictionary = new DictionaryUtil("dictionaryDataNull.json");
        assertEquals("Dictionary data can't be null", dictionary.getSortedDictionaryInRange("peak", "pique"));
    }
}
