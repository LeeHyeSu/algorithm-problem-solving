import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];         
        for(int i = 0; i < stages.length; i++) {
            count[stages[i]]++;
        }
        
        HashMap<Integer, Double> failMap = new HashMap<>();
        int p = stages.length;
        for(int i = 1; i < count.length-1; i++) {
            p -= count[i-1];
            double rate = (p > 0) ? ((double) count[i] / p) : 0;
            failMap.put(i, rate);
        }
        
        List<Integer> keySetList = new ArrayList<>(failMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (failMap.get(o2).compareTo(failMap.get(o1))));
        
        int[] answer = new int[keySetList.size()];
        int idx = 0;
        for(Integer key : keySetList) {
            answer[idx++] = key;
        }
        return answer;
    }
}