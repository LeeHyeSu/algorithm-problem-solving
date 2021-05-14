import java.util.*;

class Solution {
    HashMap<String, Integer> map;   // key: 단품 메뉴 조합, value: 주문된 횟수
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        // 단품 메뉴 개수별로 코스요리의 메뉴 구성 만들기
        for (int len : course) {
            map = new HashMap<>();
            for (String order : orders) {
                /*
                 * "XY", "YX" 는 같은 메뉴들의 조합이므로 함께 처리해주기 위해
                 * order 을 char 배열로 변환하여 사전순 정렬시킨 후에 다시 String으로 변환
                 */
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                order = String.valueOf(arr);
                
                dfs(order, 0, 0, len, "");  // 손님별로 단품 메뉴 조합 구하기
            }
            
            // 단품 메뉴 조합 중 가장 많이 주문된 횟수 구하기
            int max = 0;
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value > max) {
                    max = value;
                }
            }
            
            if (max < 2) continue;  // 최댓값이 2가 되지 않으면 list에 넣지 않고 넘어가기
            
            // 주문된 횟수가 최댓값인 단품 메뉴 조합을 list에 넣기
            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    list.add(key);
                }
            }
        }
        
        Collections.sort(list); // 코스요리 메뉴의 구성을 사전순 오름차순으로 정렬
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
    
    public void dfs(String order, int at, int count, int len, String pick) {
        if (count == len) { 
            // map 에 pick(단품 메뉴 조합)을 key 값으로 넣으면서 value(주문된 횟수) 값을 증가시킴
            map.put(pick, map.getOrDefault(pick, 0) + 1);
            return;
        }
        
        for (int i = at; i < order.length(); i++) {
            dfs(order, i + 1, count + 1, len, pick + order.charAt(i));
        }
    }
}