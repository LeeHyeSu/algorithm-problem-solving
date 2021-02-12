import java.util.Scanner;

public class Main {
	static int[] dp = new int[30];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		/*
		 * 수열의 길이 구하기
		 * : S(k) = S(k-1) * 2 + (3 + k)
		 * 거의 2배씩 늘어나고 2^30은 10억보다 크므로 30까지만 구한다.
		 */
		dp[0] = 3;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = (dp[i-1] * 2) + (i + 3);
		}
		
		System.out.println(solve(n));
		
		sc.close();
	}

	static char solve(int n) {
		if (n <= 3) {
			if (n == 1) return 'm';
			else return 'o';
		}
		
		// 지금 n이 몇 번째 index 인지 찾기
		int i = 0;
		while (dp[i] < n) i++;
		
		// m o o ... 구간에 속하는 경우
		if (n == dp[i - 1] + 1) return 'm';
		else if (n <= dp[i - 1] + i + 3) return 'o';
		
		// S(N - 1) 구간에 속하는 경우, 재귀 호출
		return solve((n - dp[i - 1] - (i + 3)));
	}
}