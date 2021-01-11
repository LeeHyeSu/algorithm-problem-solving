import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][11];
        
        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
    	for(int i = 1; i <= 9; i++) {
    		dp[1][i] = 1;
    	}
    	
    	for(int i = 2; i <= N; i++) {
            /*
             * N번째 자릿수의 자릿값이 0인 경우 : 다음 자릿수의 자릿값은 1 만 가능
             * N번째 자릿수의 자릿값이 9인 경우 : 다음 자릿수의 자릿값은 8 만 가능
             * 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
             */
    		dp[i][0] = dp[i-1][1];
    		for(int j = 1; j <= 9; j++) {
        		dp[i][j] = (dp[i-1][j+1]+dp[i-1][j-1]) % 1000000000;
        		// j = 9 이면 dp[i][9] = 0 + dp[i-1][8]
        	}
    	}
    	
    	long sum = 0;
    	for(int i = 0; i < 10; i++) {
    		sum += dp[N][i];
    	}
    	
    	System.out.println(sum % 1000000000);
    }

}