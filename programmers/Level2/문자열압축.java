import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String now = "";
            String next = "";
            String result = "";
            int cnt = 1;
            
            for (int j = 0; j <= s.length() / i; j++) {
                int start = i * j;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);

                now = next;
                next = s.substring(start, end);
                
                if (now.equals(next)) {
                    cnt++;
                } else {
                    result +=  cnt > 1 ? cnt + now : now;
                    cnt = 1;
                }
            }

            result += cnt > 1 ? cnt + next : next;
            answer = Math.min(result.length(), answer);
        }
        
        return answer;
    }
}