import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i : scoville) {
            heap.offer(i);
        }
    
        int cnt = 0;
        while (heap.peek() < K) {
            if (heap.size() == 1) return -1;
            
            heap.offer(heap.poll() + (heap.poll() * 2));
            cnt++;
        }
        
        return cnt;
    }
}