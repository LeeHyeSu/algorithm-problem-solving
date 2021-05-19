import java.util.*;

class Solution {
    
    char[] op = {'+', '-', '*'};
    boolean[] check = new boolean[3];
    List<Long> nums = new ArrayList<>();        // 피연산자(숫자) 리스트
    List<Character> ops = new ArrayList<>();    // 연산자 리스트
    long answer = 0;
    
    public long solution(String expression) {
        
        String n = "";
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                n += ch;
            } else {
                nums.add(Long.parseLong(n));
                n = "";
                ops.add(ch);
            }
        }
        nums.add(Long.parseLong(n));
        
        dfs(0, new char[3]);
        return answer;
    }
    
    public Long calc(Long num1, Long num2, char op) {
        long n = 0;
    
        switch (op) {
            case '+': 
                n = num1 + num2;
                break;
            case '-':
                n = num1 - num2;
                break;
            case '*':
                n = num1 * num2;
                break;
        }
        
        return n;
    }
    
    void dfs(int count, char[] prior) {
        if (count == 3) {
            // 원본 피연산자/연산자 리스트를 복사
            List<Long> copyNums = new ArrayList<>(nums);
            List<Character> copyOps = new ArrayList<>(ops);
            
            // 우선순위에 맞게 계산, 숫자는 연산자보다 항상 1개가 많다
            for (int i = 0; i < prior.length; i++) {
                for (int j = 0; j < copyOps.size(); j++) {
                    if (prior[i] == copyOps.get(j)) {
                        // 리스트는 지울 때 한 칸씩 밀리고 배열의 사이즈가 동적으로 변하므로 
                        // j를 두 번 remove 하고 j-- 처리해줌
                        Long result = calc(copyNums.remove(j), copyNums.remove(j), prior[i]);
                        copyNums.add(j, result);
                        copyOps.remove(j);
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(copyNums.get(0)));
            return;
        }
        
        // 모든 우선순위 조합구하기
        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                prior[count] = op[i];
                dfs(count + 1, prior);
                check[i] = false;
            }
        }
    }
    
}