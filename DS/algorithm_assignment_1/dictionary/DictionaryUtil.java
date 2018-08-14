package algorithm_assignment_1.dictionary;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Ayushi Khandelwal
 *
 */
public class DictionaryUtil implements Dictionary {
    
    TreeMap<String, String> dictionaryData;
    List<String> sortedDictionary;
    
    /**
     * @param jsonFile
     */
    public DictionaryUtil(String jsonFile) {
        dictionaryData = new TreeMap<>();
        sortedDictionary = new ArrayList<>();

        File file = null;
        try {
            file = new File(jsonFile);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));

            //keySet() gives us all keys of JSONObject
            for(Object word : jsonObject.keySet()) {
                addWord(word.toString(), jsonObject.get(word).toString());
            }
        }
        catch(Exception e) {
            e.getMessage();
        }
    }

    @Override
    public boolean addWord(String word, String meaning) {
        if(dictionaryData.equals(null))
            throw new AssertionError("Dictionary data can't be null");
        
        if(word.equals(null))
            throw new AssertionError("word cannot be null!!");
        
        else if(meaning.equals(null))
            throw new AssertionError("meaning cannot be null!!");
            
        dictionaryData.put(word, meaning);
        return true;
    }

    @Override
    public boolean deleteWord(String word) {
        if(dictionaryData.equals(null))
            throw new AssertionError("Dictionary data can't be null");
        
        if(!dictionaryData.containsKey(word))
            throw new AssertionError(word + " does not exist");
        
        dictionaryData.remove(word);
        return true;
    }

    @Override
    public String getMeaning(String word) {
        if(dictionaryData.equals(null))
            throw new AssertionError("Dictionary data can't be null");
        
        if(word.equals(null))
            throw new AssertionError("word cannot be null!!");
        
        else if(!dictionaryData.containsKey(word))
            throw new AssertionError(word + "Word does not exist");
        
        return dictionaryData.get(word);
    }

    @Override
    public String getSortedDictionary() {
        if(dictionaryData.equals(null))
            throw new AssertionError("Dictionary data can't be null");
        
        for(Entry<String,String> entry : dictionaryData.entrySet()){
            sortedDictionary.add(entry.getKey() + " --> " + entry.getValue());
        }
        
        return sortedDictionary.toString();
    }

    @Override
    public String getSortedDictionaryInRange(String wordsFrom, String wordsTo) {
        if(wordsFrom == null || wordsTo == null) 
            throw new AssertionError("Data can't be null");
        
        if(dictionaryData.equals(null)) 
            throw new AssertionError("Dictionary data can't be null");
            
        for(Entry<String, String> entry : dictionaryData.entrySet()) {
            if(entry.getKey().compareTo(wordsFrom) >= 0 && entry.getKey().compareTo(wordsTo) <= 0) {
                sortedDictionary.add(entry.getKey() + " --> " + entry.getValue());
            }
        }

        return sortedDictionary.toString();
    }
}
