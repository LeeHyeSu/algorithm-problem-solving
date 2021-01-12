public class 11054 {
    
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] a = new int[n+1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		a[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[][] dp = new int[2][n+1];
    	dp[0][1] = 1;	// 왼쪽에서 시작하는 LIS
    	dp[1][n] = 1;	// 오른쪽에서 시작하는 LDS
    	
    	for(int i = 2; i <= n; i++) {	// 왼쪽에서 시작하는 LIS
    		dp[0][i] = 1;
    		for(int j = 1; j < i; j++) {
    			if(a[j] < a[i]) {
    				dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
    			}
    		}
    	}
    	
    	for(int i = n-1; i >= 1; i--) {	// 오른쪽에서 시작하는 LDS
    		dp[1][i] = 1;
    		for(int j = n; j > i; j--) {
    			if(a[j] < a[i]) {
    				dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
    			}
    		}
    	}
    	
    	for(int i = 1; i <= n; i++) {	// 두 배열의 값들을 더해준다
    		dp[0][i] += dp[1][i];
    	}
    	
    	int max = 0;
    	for(int i = 1; i <= n; i++) {
    		max = Math.max(dp[0][i], max);
    	}
    	
    	System.out.println(max-1);		// 최댓값을 찾아 -1 해주기
    }

}