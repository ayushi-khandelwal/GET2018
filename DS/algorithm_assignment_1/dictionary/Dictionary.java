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
public class Dictionary implements IDictionary {
    
    TreeMap<String, String> treeMap;
    List<String> list;
    
    /**
     * @param jsonFile
     */
    public Dictionary(String jsonFile) {
        treeMap = new TreeMap<>();
        list = new ArrayList<>();

        File file = null;
        try {
            file = new File("C:/metacube/GET2018/src/algorithm_assignment_1/dictionary" + "/" + jsonFile);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(new FileReader(file));

            //keySet() gives us all keys of JSONObject
            for(Object word : object.keySet()) {
                addWord(word.toString(), object.get(word).toString());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addWord(String word, String meaning) {
        if(word.equals(null))
            throw new AssertionError("word cannot be null!!");
        
        else if(meaning.equals(null))
            throw new AssertionError("meaning cannot be null!!");
            
        treeMap.put(word, meaning);
        return true;
    }

    @Override
    public boolean deleteWord(String word) {
        if(!treeMap.containsKey(word))
            throw new AssertionError(word + " does not exist");
        
        treeMap.remove(word);
        return true;
    }

    @Override
    public String getMeaning(String word) {
        if(word.equals(null))
            throw new AssertionError("word cannot be null!!");
        
        else if(!treeMap.containsKey(word))
            throw new AssertionError(word + " does not exist");
        
        return treeMap.get(word);
    }

    @Override
    public String getSortedWordDictionary() {
        for(Entry<String,String> entry : treeMap.entrySet()){
            list.add(entry.getKey() + " --> " + entry.getValue());
        }
        
        return list.toString();
    }

    @Override
    public String getSortedWordDictionary(String wordsFrom, String wordsTo) {
        if(wordsFrom == null || wordsTo == null) 
            throw new AssertionError("words can't be null");
        
        for(Entry<String, String> entry : treeMap.entrySet()) {
            if(entry.getKey().compareTo(wordsFrom) >= 0 && entry.getKey().compareTo(wordsTo) <= 0) {
                list.add(entry.getKey() + " --> " + entry.getValue());
            }
        }

        return list.toString();
    }
}
