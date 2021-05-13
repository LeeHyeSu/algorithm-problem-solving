import java.util.*;

class Solution {
    public String solution(String p) {
        String answer =  divide(p);
        return answer;
    }
    
    public String divide(String w) {
        if (w.equals("")) {
            return "";
        }
        
        int left = 0, right = 0;
        int idx = 0;
        
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                idx = i;
                break;
            }
        }
        
        String u = w.substring(0, idx+1);
        String v = w.substring(idx+1);
        
        String result = "";
        if (isCorrect(u)) {
            result = u + divide(v);
        } else {
            result = "(" + divide(v) + ")";
            for (int i = 1; i < u.length()-1; i++) {
                result += (u.charAt(i) == '(') ? ")" : "(";
            }
        }
        
        return result;
    }
    
    public boolean isCorrect(String w) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                stack.push(w.charAt(i)); 
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}