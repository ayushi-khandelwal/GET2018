package ds_Assignment_4.StringIntoUniqueCharacters;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

public class CountUniqueChars {
    static HashedMap<String, Integer> map;
    static Set<Character> uniqueChars;
    static Set<Character> repeatedChars;
    
    public CountUniqueChars() {
        map = new HashedMap<String, Integer>();
        uniqueChars = new HashSet<Character>();
        repeatedChars = new HashSet<Character>();
    }
     
    public int countUniqueChars(String input) {
        input = input.toLowerCase();
        uniqueChars.clear();
        repeatedChars.clear();
        if(checkInCache(input) > 0)
            return checkInCache(input);
       
        for(int i = 0; i < input.length(); i++) {
            if(uniqueChars.contains(input.charAt(i))) {
                repeatedChars.add(input.charAt(i));
                uniqueChars.remove(input.charAt(i));
            }
            else if(!repeatedChars.contains(input.charAt(i))) {
                uniqueChars.add(input.charAt(i));
            }
        }
        map.put(input, uniqueChars.size());
        System.out.println(input + ", " + uniqueChars.toString());
        return uniqueChars.size();
    }
    
    @SuppressWarnings({ "rawtypes" })
    public int checkInCache(String input) {
        
        if(map.isEmpty()) 
            return 0;
        
        if(map.containsKey(input)) 
            return map.get(input);
        
        return 0;
    }
}
