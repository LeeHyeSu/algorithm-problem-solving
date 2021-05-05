class Solution {
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return count;
    }
    
    public void dfs(int[] numbers, int target, int depth) {
        if(depth == numbers.length) {
            int sum = 0;
            for(int i : numbers) {
                sum += i;
            }
            if(sum == target) count++; 
            return;
        }
        
        numbers[depth] *= 1;
        dfs(numbers, target, depth + 1);
        numbers[depth] *= -1;
        dfs(numbers, target, depth + 1);
    }
}