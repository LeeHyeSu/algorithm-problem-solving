import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[][] str = new String[record.length][3];
        
        for (int i = 0; i < record.length; i++) {
            str[i] = record[i].split(" ");
            if (str[i][0].equals("Leave")) continue;
            
            map.put(str[i][1], str[i][2]);   
        }
        
        List<String> list = new ArrayList<>();
        String userId = "";
        String nickname = "";
        
        for (int i = 0; i < record.length; i++) {
            userId = str[i][0];
            nickname = map.get(str[i][1]);
            
            if (userId.equals("Enter")) {
                list.add(nickname + "님이 들어왔습니다.");
            } 
            else if (userId.equals("Leave")) {
                list.add(nickname + "님이 나갔습니다.");
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}