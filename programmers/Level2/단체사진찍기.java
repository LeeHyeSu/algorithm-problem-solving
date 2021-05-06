import java.util.*;

class Solution {
    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] position;
    static boolean[] checked;
    static int answer;
    
    public int solution(int n, String[] data) {
        position = new char[8];
        checked = new boolean[8];
        answer = 0;
        
        backtracking(0, n, data);
        
        return answer;
    }
    
    public void backtracking(int idx, int n, String[] data) {
        if (idx == 8) {
            if (isPossible(n, data)) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!checked[i]) {
                checked[i] = true;
                position[idx] = character[i];
                backtracking(idx + 1, n, data);
                checked[i] = false;
            }
        }
    }
    
    public boolean isPossible(int n, String[] data) {
        for (int i = 0; i < n; i++) {
            char[] condition = data[i].toCharArray();
            int from = 0, to = 0, gap = 0, dist = condition[4] - '0';
            
            for (int j = 0; j < 8; j++) {
                if (position[j] == condition[0]) from = j;
                if (position[j] == condition[2]) to = j;
            }
            
            gap = Math.abs(from - to) - 1;
            
            switch (condition[3]) {
                case '=':
                    if (gap != dist) return false;
                    break;
                case '<':
                    if (gap >= dist) return false;
                    break;
                case '>':
                    if (gap <= dist) return false;
                    break;
            }
        }
        return true;
    }
    
}