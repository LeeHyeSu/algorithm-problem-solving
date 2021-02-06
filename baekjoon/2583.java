import java.io.*;
import java.util.*;

public class Main {
	static int m, n, k;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		visited = new boolean[n][m];
		int[] x = new int[2];
		int[] y = new int[2];
		
		while (k > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = x[0]; i < x[1]; i++) {
				for (int j = y[0]; j < y[1]; j++) {
					map[i][j] = true;
				}
			}
			
			k--;
		}
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && !map[i][j]) {
					dfs(i, j);
					list.add(count);
					count = 0;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int value : list) {
			System.out.print(value + " ");
		}
	}
	
	static void dfs(int x, int y) {
		if (visited[x][y] || map[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
				dfs(nextX, nextY);
			}
		}
	}

}