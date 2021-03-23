import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	int[] dp = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = 0;
    	for (int i = 0; i < n; i++) {
    		dp[i] = arr[i];
    		for (int j = 0; j < i; j++) {
    			if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
    				dp[i] = dp[j] + arr[i];
    			}
    		}
    		max = Math.max(max, dp[i]);
    	}
    	
    	System.out.println(max);
    }

}