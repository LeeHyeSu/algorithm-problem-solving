import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        /* 
         * 제일 앞과 끝의 두 글자는 필요없으므로 substring()으로 잘라주고
         * 튜플을 나누기 위해서 '},{' -> '-' 로 변환
         * 나누어진 튜플을 split을 이용해서 배열에 저장하고 길이의 오름차순으로 정렬
         * 길이에 따라 정렬된 값을 하나씩 가져와서 정수형으로 바꾸고
         * 중복되지 않도록 리스트에 저장
         */
        s = s.substring(2, s.length()-2).replace("},{", "-");
        
        String[] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        for (String temp : arr) {
            String[] val = temp.split(",");
            
            for (int i = 0; i < val.length; i++) {
                int num = Integer.valueOf(val[i]);
                
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}