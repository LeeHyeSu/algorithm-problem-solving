import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    String[] arr; 
    boolean[] visited;
    
    public int solution(String numbers) {
        arr = numbers.split("");
        visited = new boolean[arr.length];

        for (int i = 1; i <= arr.length; i++) {
            permutation(arr.length, i, "", 0);
        }
        
        int answer = 0;
        Iterator iter = set.iterator();
        
        while (iter.hasNext()) {
            int n = (int) iter.next();
            if (isPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void permutation(int n, int r, String s, int depth) {
        if (depth == r) {
            set.add(Integer.parseInt(s));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(n, r, s + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}