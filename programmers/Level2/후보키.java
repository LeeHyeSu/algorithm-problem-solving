import java.util.*;

/*
 * 비트마스크 풀이법
 * 1. 모든 열(속성)의 조합을 구한다.
 * 2. 만들어진 조합이 이전에 만들어진 후보키를 포함하는지 확인한다.
 *   2-1. 포함된다면 다음 조합으로 넘어간다.
 *   2-2. 포함되지 않는다면 유일성을 체크하여 후보키 여부를 판단한다.
 * 3. 후보키의 갯수를 반환한다.
 */
class Solution {
    ArrayList<Integer> list;
    int rowSize;
    int colSize;
    
    public int solution(String[][] relation) {
        list = new ArrayList<>();
        rowSize = relation.length;
        colSize = relation[0].length;
        
        for (int i = 1; i < (1 << colSize); i++) {
            if (!checkMinimality(i)) continue;  // 최소성을 만족하지 못하면 패스
            if (!checkUniqueness(i, relation)) continue;  // 유일성을 만족하지 못하면 패스
            
            list.add(i);
        }
        
        return list.size();
    }
    
    boolean checkMinimality(int set) {
        for (int key : list) {
            if ((set & key) == key) return false;  // 중복되어 있으면 false
        }
        return true;
    }
    
    boolean checkUniqueness(int set, String[][] relation) {
        ArrayList<Integer> s = getSet(set);
        HashSet<String> hashSet = new HashSet<>();
        
        for (int r = 0; r < rowSize; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c : s) {
                sb.append(relation[r][c]);
            }
            
            hashSet.add(sb.toString());
        }
        
        return hashSet.size() == rowSize;
    }
    
    ArrayList<Integer> getSet(int set) {  // 0101 -> [0, 2]로 변환
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < colSize; i++) {
            if (((set >> i) & 1) == 1) result.add(i);
        }
        
        return result;
    }
}