import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new char[n][n * 2 - 1]; 	// n이 3일 때 3 * 5 행렬이 만들어짐
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], ' ');	// 배열 내부 모두 공백문자로 초기화
		}
		
		solve(0, n - 1, n);		// 가장 꼭대기 * 좌표에서 시작
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		sc.close();
	}

	static void solve(int row, int col, int size) {
		
		// 패턴의 가장 작은 단위(size == 3) 라면 별 출력
		if (size == 3) {
			map[row][col] = '*';
			map[row+1][col+1] = map[row+1][col-1] = '*';
			map[row+2][col-2] = map[row+2][col-1] = map[row+2][col] = map[row+2][col+1] = map[row+2][col+2] = '*';
		
			return;
		}
		
		// 아니라면, 반으로 쪼개어 재귀 호출하기
		size /= 2;
		
		solve(row, col, size);
		solve(row + size, col + size, size);		// 오른쪽
		solve(row + size, col - size, size);		// 왼쪽
	}
}
