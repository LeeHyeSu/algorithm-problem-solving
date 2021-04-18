import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1);
        for(int i : lost) students[i-1]--;
        for(int i : reserve) students[i-1]++;

        for(int i = 0; i < students.length; i++) {
            if(students[i] == 2) {
                if(i != 0 && students[i-1] == 0) {
                    students[i-1]++;
                    students[i]--;
                    continue;
                }
                if(i != students.length-1 && students[i+1] == 0) {
                    students[i+1]++;
                    students[i]--;
                }
            }
        }

        int answer = 0;
        for(int student : students) {
            if(student != 0) answer++; 
        }
        return answer;
    }
}