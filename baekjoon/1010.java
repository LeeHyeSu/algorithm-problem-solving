import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(comb(M, N)).append('\n');
			
			T--;
		}
		
		System.out.println(sb);
	}

	private static int comb(int m, int n) {
		if (dp[m][n] != 0) return dp[m][n];
		
		if (n == 0 || n == m) {
			dp[m][n] = 1;
		} else {
			dp[m][n] = comb(m - 1, n - 1) + comb(m - 1, n);
		}
		
		return dp[m][n];
	} 

}  