import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && dp[j] >= dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);	// 가장 긴 증가하는 부분 수열의 길이 출력
		
		String ans = "";
		for (int i = n - 1; i >= 0; i--) {	// 수열의 뒤에서부터 인덱스 확인
			if (dp[i] == max) {
				ans = a[i] + " " + ans;
				max--;
			}
		}
		
		System.out.println(ans);	// 가장 긴 증가하는 부분 수열 출력
	}

 }