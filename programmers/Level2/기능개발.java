import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];    // 작업 배포 가능 일수 배열
        
        for (int i = 0; i < n; i++) {   // 작업 배포 가능 일수 계산
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = (100 - progresses[i]) / speeds[i];
            } else {
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
           
        }
        
        int today = days[0];    // 오늘 날짜
        int cnt = 1;            // 배포되는 기능 수
        List<Integer> list = new ArrayList<>();     // 배포되는 기능 횟수 리스트
        for (int i = 1; i < n; i++) {
            if (days[i] <= today) {     // 작업의 배포 가능 일수가 오늘 날짜보다 작으면 배포되는 기능 횟수 증가
                cnt++;
            } else {
                today = days[i];        // 작업의 배포 가능 일수가 오늘 날짜보다 크면 배포되는 기능 수 list에 추가
                list.add(cnt);
                cnt = 1; 
            }
        }
        list.add(cnt);
        
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}