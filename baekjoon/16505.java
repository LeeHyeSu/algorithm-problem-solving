import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int size = (int)Math.pow(2, n);
		
		map = new char[size][size];
		
		for (int i = 0; i < size; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		solve(size - 1, 0, size);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	static void solve(int row, int col, int size) {
		if (size == 1) {
			map[row][col] = '*';
			return;
		}
		
		size /= 2;
		
		solve(row, col, size);
		solve(row - size, col, size);
		solve(row - size, col + size, size);
	}

}