import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
/*
 * 참고 : https://gwang920.github.io/algorithm/progreammers-1-72412/
 * 1. info[] 배열로 '-'를 포함한 모든 경우의 수를 만들어준다.
 * 1-1. 경우의 수를 String 으로 만들어준다.
 * 1-2. 모든 경우의 수를 Map<String,List<Integer>> map 에 {String, List} 쌍으로 저장한다.
 * 2. 이분 탐색을 통해 답을 구해준다.
      순차적으로 탐색하면 시간초과가 발생한다.
      이분 탐색으로 "목표점수 > list[idx] && 목표점수 <= list[idx]"
      에 해당하는 'index'를 구해준다.
      "x 점 이상 받은 사람은 모두 몇 명인가?"를 구해야하고,
      한 list 안에 동일한 점수가 존재할 수 있기 때문에
      조건을 만족하는 가장 작은 index 값을 선택해야한다.
      index가 구해졌다면 list.size() - index를 해주면 답이된다.
 */
class Solution {
    Map<String,List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
            
        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }
        
        for (String key : map.keySet()) {
            List<Integer> values = map.get(key);
            Collections.sort(values);
        }
        
        for (int i = 0; i < query.length; i++) {
            String str = "";
            String[] arr = query[i].replaceAll(" and ", " ").split(" ");
            
            for (int j = 0; j < arr.length-1; j++) {
                str += arr[j];
            }
            
            answer[i] = count(str, Integer.parseInt(arr[arr.length-1]));
        }
        
        return answer;
    }
    
    void dfs(String str, int depth, String[] info) {
        if (depth == 4) {
            if (!map.containsKey(str)) {
                List<Integer> scores = new ArrayList<>();
                scores.add(Integer.parseInt(info[4]));
                map.put(str, scores);
            } else {
                map.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }
        
        dfs(str + "-", depth + 1, info);
        dfs(str + info[depth], depth + 1, info);
    }
    
    int count(String str, int score) {
        if (!map.containsKey(str)) return 0;
        
        List<Integer> scores = map.get(str);
        int start = 0, end = scores.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return scores.size() - start;
    }
    
}