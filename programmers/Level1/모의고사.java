import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == s1[i % 5]) cnt[0]++;
            if(answers[i] == s2[i % 8]) cnt[1]++;
            if(answers[i] == s3[i % 10]) cnt[2]++;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for(int i = 0; i < 3; i++) {
            if(max == cnt[i]) list.add(i+1);
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;  
    }
}