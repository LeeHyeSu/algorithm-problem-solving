class Solution {
    public int solution(int n) {
        String tmp = "";
        while(n > 0) {
            tmp = String.valueOf(n % 3) + tmp;
            n /= 3;
        }

        int answer = 0;
        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) != '0') {
                answer += (tmp.charAt(i) - '0') * Math.pow(3, i);
            }
        }
        return answer;
    }
}