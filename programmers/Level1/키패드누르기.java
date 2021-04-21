class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int[] leftPos = {3, 0};        // * 위치에서 시작 -> [3][0]
        int[] rightPos = {3, 2};       // # 위치에서 시작 -> [3][2]
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                for(int j = 0; j < 3; j++) {
                    if(keypad[j][0] == numbers[i]) {
                        leftPos[0] = j;
                        leftPos[1] = 0;
                    }
                }
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                for(int j = 0; j < 3; j++) {
                    if(keypad[j][2] == numbers[i]) {
                        rightPos[0] = j;
                        rightPos[1] = 2;
                    }
                }
            } else {
                int idx = 0;
                for(int j = 0; j < 4; j++) {
                    if(keypad[j][1] == numbers[i]) {
                        idx = j;
                        break;
                    }
                }
                
                int distLeft = Math.abs(leftPos[0] - idx) + Math.abs(leftPos[1] - 1);
                int distRight = Math.abs(rightPos[0] - idx) + Math.abs(rightPos[1] - 1);
                if(distLeft < distRight) {
                    answer += "L";
                    leftPos[0] = idx;
                    leftPos[1] = 1;
                } else if(distLeft > distRight) {
                    answer += "R";
                    rightPos[0] = idx;
                    rightPos[1] = 1;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        leftPos[0] = idx;
                        leftPos[1] = 1;
                    } else {
                        answer += "R";
                        rightPos[0] = idx;
                        rightPos[1] = 1;
                    }
                }
            }
        }
        
        return answer;
    }
}