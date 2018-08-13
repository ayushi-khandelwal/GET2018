package ds_Assignment_4.StringIntoUniqueCharacters;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

public class UniqueCharacters {
    static HashedMap<String, Integer> dataMap;
    static Set<Character> uniqueCharacters;
    static Set<Character> repeatedCharacters;
    
    public UniqueCharacters() {
        dataMap = new HashedMap<String, Integer>();
        uniqueCharacters = new HashSet<Character>();
        repeatedCharacters = new HashSet<Character>();
    }
     
    public int countUniqueCharacters(String inputString) {
        inputString = inputString.toLowerCase();
        uniqueCharacters.clear();
        repeatedCharacters.clear();
        if(checkInCache(inputString) > 0)
            return checkInCache(inputString);
       
        for(int i = 0; i < inputString.length(); i++) {
            if(uniqueCharacters.contains(inputString.charAt(i))) {
                repeatedCharacters.add(inputString.charAt(i));
                uniqueCharacters.remove(inputString.charAt(i));
            }
            else if(!repeatedCharacters.contains(inputString.charAt(i))) {
                uniqueCharacters.add(inputString.charAt(i));
            }
        }
        dataMap.put(inputString, uniqueCharacters.size());
        return uniqueCharacters.size();
    }
    
    public int checkInCache(String inputString) {
        
        if(dataMap.isEmpty()) 
            return 0;
        
        if(dataMap.containsKey(inputString)) 
            return dataMap.get(inputString);
        
        return 0;
    }
}