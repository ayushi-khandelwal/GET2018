package algorithm_assignment_1.dictionary;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class DictionaryTest {

    Dictionary dictionary = new Dictionary("data.json");
    
    @Test
    public void test_addWord_WhenKeyAndValueArePassed_ReturnTrue() {
        assertEquals(true, dictionary.addWord("file", "used to store data"));
        assertEquals(true, dictionary.addWord("earphones", "used to listen music"));
        assertEquals(true, dictionary.addWord("book", "used to gain knowledge"));
    }

    @Test(expected = AssertionError.class)
    public void test_addWord_WhenKeyIsNotPassed_ThrowAssertionError() {
        assertEquals("Key cannot be null!!", dictionary.addWord("", "used to store data"));
    }

    @Test(expected = AssertionError.class)
    public void test_addWord_WhenValueIsNotPassed_ThrowAssertionError() {
        assertEquals("Value cannot be null!!", dictionary.addWord("file", ""));
    }
    
    @Test
    public void test_deleteWord_WhenKeyIsPassed_ReturnTrue() {
        assertEquals(true, dictionary.deleteWord("peak"));
        assertEquals(true, dictionary.deleteWord("apple"));
    }

    @Test(expected = AssertionError.class)
    public void test_deleteWord_WhenKeyIsNotPassed_ReturnTrue() {
        dictionary.deleteWord("");
    }
    
    @Test
    public void test_getMeaning_WhenKeyIsPassed_ReturnValue() {
        assertEquals("an animal", dictionary.getMeaning("tiger"));
    }

    @Test(expected = AssertionError.class)
    public void test_getMeaning_WhenKeyIsNotPassed_ReturnTrue() {
        assertEquals(" does not exist", dictionary.getMeaning(""));
    }

    @Test
    public void test_getSortedWordDictionary_WhenKeyIsPassed_ReturnValue() {
        assertEquals("[apple --> a fruit, peak --> topmost point, peek --> glance or a quick look, pen --> used to write something, "
                + "pique --> to make someone angry or annoyed, tiger --> an animal]", dictionary.getSortedWordDictionary());
    }

    @Test
    public void test_get_WhenKeyIsPassed_ReturnValue() {
        assertEquals("[peak --> topmost point, peek --> glance or a quick look, pen --> used to write something, "
                + "pique --> to make someone angry or annoyed]", dictionary.getSortedWordDictionary("peak", "pique"));
    }
    
}
