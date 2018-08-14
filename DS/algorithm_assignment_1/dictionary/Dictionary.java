package algorithm_assignment_1.dictionary;

/**
 * @author Ayushi Khandelwal
 *
 */
public interface Dictionary {
    public boolean addWord(String word, String meaning);
    public boolean deleteWord(String word);
    public String getMeaning(String word);
    public String getSortedDictionary();
    public String getSortedDictionaryInRange(String wordsFrom, String wordsTo);
}
