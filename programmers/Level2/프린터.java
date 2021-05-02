import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> priorQ = new LinkedList<>();     // 문서의 중요도를 담은 큐
        Queue<Integer> indexQ = new LinkedList<>();     // 문서의 위치를 담은 큐
        
        for (int i = 0; i < priorities.length; i++) {
            priorQ.add(priorities[i]);
            indexQ.add(i);
        }
        
        int max = Collections.max(priorQ);              // 가장 중요도가 높은 문서를 계산하여 저장
        int answer = 1;                                 // 프린트 횟수를 세는 변수
        
        while (!priorQ.isEmpty()) {
            if (max > priorQ.peek()) {                  // 가장 중요도가 높은 문서가 아닌 문서들은 대기목록의 마지막에 넣음
                priorQ.add(priorQ.poll());
                indexQ.add(indexQ.poll());
            } else {                                    // 인쇄 대기목록의 가장 앞에 있는 문서가 가장 중요도가 높은 문서일 때
                if (indexQ.peek() == location) {        // 인쇄를 요청한 문서가 제일 앞에 있다면 answer 값 반환
                    break;
                }
                
                priorQ.poll();                          // 인쇄를 요청한 문서가 아니라면 프린트 후 answer 값 증가
                indexQ.poll();
                answer++;
                
                max = Collections.max(priorQ);          // 가장 중요도가 높은 문서를 다시 계산
            }
        }
        
        return answer;
    }
}