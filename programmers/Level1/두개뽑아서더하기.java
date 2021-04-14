import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            answer[idx++] = (int) iter.next();
        }
        
        return answer;
    }
}