import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	char[] a = br.readLine().toCharArray();
    	char[] b = br.readLine().toCharArray();
    	
    	int[][] dp = new int[a.length+1][b.length+1];
    	
    	for(int i = 1; i <= a.length; i++) {
    		for(int j = 1; j <= b.length; j++) {
                // (i-1) 번째 문자와 (j-1) 번째 문자가 서로 같다면 
    			if(a[i-1] == b[j-1]) {
                    // 대각선 위 (i-1, j-1) 의 dp에 +1 한 값으로 갱신
    				dp[i][j] = dp[i-1][j-1] + 1;
    			} else {
                    // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	
    	System.out.println(dp[a.length][b.length]);
    }

}