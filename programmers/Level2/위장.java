import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        /* 4 종류의 옷과 그 옷이 {n, m, o, p} 의 개수로 있을 때 경우의 수는 아래와 같다.
         * (n + 1) * (m + 1) * (o + 1) * (p + 1) - 1
         * 각 종류들은 하나를 입거나, 안입거나의 선택지가 있기 때문에
         * 옷의 개수에 안입는 선택지를 하나 추가한다.
         * 옷을 고르는 선택은 동시에 일어나는 일이므로 각 옷들의 개수를 곱해 경우의 수를 계산한다.
         * 이 때, 하나도 안입는 선택지는 없으므로 경우의 수를 하나 뺀다.
         */ 
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for (int count : map.values()) {
            answer *= count + 1;
        }
        
        return answer - 1;
    }
}