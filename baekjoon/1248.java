import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] pick;
	static char[][] S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new char[N][N];
		
		String input = br.readLine();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i <= j) {
					S[i][j] = input.charAt(idx++);
				}
			}
		}
		
		pick = new int[N];
		solution(0);
	}
	
	static void solution(int count) {
		if (count == N) {
			for (int num : pick) {
				System.out.print(num + " ");
			}
			System.out.println();
			System.exit(0);
		}
		
		/*
		 * pick[i] 부터 pick[j] 까지 합을 계산하여 S[i][j] 의 부호를 체크
		 * sum 이 부호와 맞으면 재귀함수 호출, 맞지 않으면 다음 숫자를 탐색함
		 */
		for (int num = -10; num <= 10; num++) {
			pick[count] = num;
			if (check(count)) solution(count + 1);
		}
	}
	
	static boolean check(int idx) {
		for (int i = 0; i <= idx ; i++) {
			int sum = 0;
			for (int j = i; j <= idx; j++) {
				sum += pick[j];
			}
			
			if (S[i][idx] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
				return false;
			}
		}
		return true;
	}

}
