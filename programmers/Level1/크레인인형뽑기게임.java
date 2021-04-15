import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 0;
        
        for(int col = 0; col < moves.length; col++) {
            for(int row = 0; row < board.length; row++) {
                int idx = board[row][moves[col]-1];
                
                if(idx != 0) {
                    if(!stack.isEmpty() && stack.peek() == idx) {
                        stack.pop();
                        cnt += 2;
                    } else {
                         stack.push(idx);
                    }
                    
                    board[row][moves[col]-1] = 0;
                    break;
                }
            }
        }
        
        return cnt;
    }
}