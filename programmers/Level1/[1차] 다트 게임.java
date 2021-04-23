class Solution {
    int[] score = new int[3];   // 3번의 점수를 입력할 배열
    
    public int solution(String dartResult) {
        char[] d = dartResult.toCharArray();
        int idx = -1;           // 배열의 인덱스 값
        for(int i = 0; i < d.length; i++) {
            if('0' <= d[i] && d[i] <= '9') {
                idx++;
                if(d[i] == '1' && d[i+1] == '0') {  // 10 처리
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = d[i] - '0';
                }
            } else {
                BonusOrOption(d[i], idx);
            }
        }
        
        int answer = 0;
        for(int s : score) {
            answer += s;
        }
        return answer;
    }
    
    public void BonusOrOption(char ch, int idx) {
        switch(ch) {
            case 'S':
                score[idx] = (int)Math.pow(score[idx], 1);
                break;
            case 'D':
                score[idx] = (int)Math.pow(score[idx], 2);
                break;
            case 'T':
                score[idx] = (int)Math.pow(score[idx], 3);
                break;
            case '*':
                score[idx] = score[idx] * 2;
                if(idx != 0) score[idx-1] = score[idx-1] * 2;
                break;
            case '#':
                score[idx] = score[idx] * (-1);
                break;
        }
        return;
    }
}