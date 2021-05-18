import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] result = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        // 정렬된 문자 하나로 합치기
        String answer = "";
        for(String a : result) {
            answer += a;
        }
        
        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}