import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] nums) {
        comb(0, 0, 0, nums);
        return answer;
    }
    
    void comb(int start, int count, int sum, int[] nums) {
        if (count == 3) {
            if (isPrime(sum)) answer++;
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            comb(i + 1, count + 1, sum + nums[i], nums);
        }
    }
    
    boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}