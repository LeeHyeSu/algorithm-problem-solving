import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[][] cost = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < i + 1; j++) {
    			cost[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] dp = new int[n][n];
    	dp[0][0] = cost[0][0];
    	for(int i = 1; i < n; i++) {
    		for(int j = 0; j < i + 1; j++) {
    			if(j == 0) {
    				dp[i][j] += dp[i-1][j] + cost[i][j];
    			} else if(j == i) {
    				dp[i][j] += dp[i-1][j-1] + cost[i][j];
    			} else {
    				dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]) + cost[i][j];
    			}		 
    		}
    	}
    	
    	Arrays.sort(dp[n-1]);
    	System.out.println(dp[n-1][n-1]);
    }

}