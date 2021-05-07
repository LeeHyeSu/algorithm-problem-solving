class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * (long)h - ((long)w  + (long)h - gcd(w, h));
        return answer;
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}