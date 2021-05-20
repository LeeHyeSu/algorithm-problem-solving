import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 선택할 수 있는 범위 내에서 가장 큰 숫자를 선택해나가는 그리디 알고리즘 
        // k개를 지우는 문제지만, cnt = length - k 라고 하고 n개를 선택하는 문제로 변경
        
        StringBuilder sb = new StringBuilder();
        
        int cnt = number.length() - k;  // 선택할 숫자의 개수
        int left = 0;
        int right = number.length() - cnt;
        int max = -1;
        int idx = 0;
        
        while (cnt > 0) {
            max = -1;
            for (int i = left; i <= right; i++) {
                int num = number.charAt(i) - '0';
                if (num > max) {
                    idx = i;
                    max = num;
                }
            }
            
            sb.append(number.charAt(idx));
            left = idx + 1;
            right = number.length() - --cnt;
        }
        
        return sb.toString();
    }
}