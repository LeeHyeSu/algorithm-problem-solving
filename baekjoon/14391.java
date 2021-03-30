import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. dfs 로 탐색 (row, col)
 * 2. 가로 숫자 = true, 세로 숫자 = false 활용
 * 3. 열을 이동하며 가로, 세로를 체크 ('true' or 'false')
 * 4. 해당 열의 모든 열을 체크한 경우 다음 행을 재귀 호출.
 * 5. 모든 맵을 탐색한 경우, 만들어진 수를 계산
 * 6. 가로 또는 세로의 덧셈을 할 때, 수의 자리(1의 자리 or 10의 자리)를 맞춰준다.
 * 7. 최댓값과 비교 후 갱신
 */
public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] checked;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		solution(0, 0);
		System.out.println(max);
	}

	static void solution(int row, int col) {
		// 모든 행 탐색 종료
		if (row >= N) {
			sum();
			return;
		}
		
		// 한 행의 모든 열 탐색 종료 -> 다음 행으로 이동(재귀)
		if (col >= M) {
			solution(row + 1, 0);
			return;
		}
		
		// 가로 숫자로 사용
		checked[row][col] = true;
		solution(row, col + 1);
		
		// 세로 숫자로 사용
		checked[row][col] = false;
		solution(row, col + 1);
	}
	
	static void sum() {
		int sum = 0;
		
		// 가로 숫자 계산
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < M; j++) {
				// true 인 경우 -> 가로 덧셈
				if (checked[i][j]) {
					temp *= 10;		// 자릿수 이동
					temp += arr[i][j];
				} else {
					sum += temp;
					temp = 0;		// temp 변수 초기화
				}
			}
			sum += temp;
		}
		
		// 세로 숫자 계산
		for (int i = 0; i < M; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				// false 일 경우 -> 세로 덧셈
				if (!checked[j][i]) {
					temp *= 10;		// 자릿수 이동
					temp += arr[j][i];
				} else {
					sum += temp;
					temp = 0;		// temp 변수 초기화
				}
			}
			sum += temp;
		}
		
		max = Math.max(max, sum);
	}
}
