class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 2; i < sum / 2; i++) {
            // i = 가로 크기, j = 세로 크기
            // i가 j보다 같거나 크면 갈색 격자의 수가 맞는지 확인
            int j = sum / i;
            if (i >= j && (i * 2 + j * 2 - 4) == brown) {
                answer[0] = i;
                answer[1] = j;
                break;
            }
        }
        
        return answer;
    }
}