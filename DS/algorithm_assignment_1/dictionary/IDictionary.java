package algorithm_assignment_1.dictionary;

/**
 * @author Ayushi Khandelwal
 *
 */
public interface IDictionary {
    public boolean addWord(String key, String value);
    public boolean deleteWord(String key);
    public String getMeaning(String key);
    public String getSortedWordDictionary();
    public String getSortedWordDictionary(String startingKey, String endingKey);
}
