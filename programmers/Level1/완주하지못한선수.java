import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        // 이름과 인원수를 각각 key-value로
        // participant를 먼저 순회하면서 인원수 + 1
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        // completion을 순회하면서 인원수 - 1
        for(String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        // 인원수가 0이 아닌 사람을 선택
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}