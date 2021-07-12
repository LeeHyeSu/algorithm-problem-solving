import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        
        List<String> set1 = makeSet(str1.toUpperCase());
        List<String> set2 = makeSet(str2.toUpperCase());
        List<String> inter = findInter(set1, set2);
        List<String> union = findUnion(set1, set2, inter);
        
        double answer = 0.0;
        if (set1.size() == 0 && set2.size() == 0) {
            answer = 1;
        } else {
            answer = (double) inter.size() / union.size();
        }
        
        return (int) (answer * 65536);
    }
    
    List<String> findInter(List<String> set1, List<String> set2) {
        List<String> copySet1 = new ArrayList<>(set1);
        List<String> copySet2 = new ArrayList<>(set2);
        List<String> inter = new ArrayList<String>();
        
	    for (String element : copySet1) {
		    if (copySet2.contains(element)) {
                inter.add(element);
                copySet2.remove(copySet2.indexOf(element));
            }
	    }
        
        return inter;
    }
    
    List<String> findUnion(List<String> set1, List<String> set2, List<String> inter) {
        List<String> copySet1 = new ArrayList<>(set1);
        List<String> copySet2 = new ArrayList<>(set2);
        List<String> union = new ArrayList<>(inter);
        
        for (String element : inter) {
            if (copySet1.contains(element)) {
                copySet1.remove(copySet1.indexOf(element));
            }
            
            if (copySet2.contains(element)) {
                copySet2.remove(copySet2.indexOf(element));
            }
        }
        
        for (String element : copySet1) {
            union.add(element);
        }
        
        for (String element : copySet2) {
            union.add(element);
        }
        
        return union;
    } 
    
    List<String> makeSet(String s) {
        List<String> set = new ArrayList<>();
        String element = "";
        
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                element += ch;
            } else {
                element = "";
            }
            
            if (element.length() == 2) {
                set.add(element);
                element = element.substring(1);
            }
        }
        
        return set; 
    }
}