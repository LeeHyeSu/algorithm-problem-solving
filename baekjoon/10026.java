import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int count = 0;
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
                    visited[i][j] = true;
					count++;
					bfs(i, j);
				}
			}
		}
		
		System.out.print(count + " ");
		
		count = 0;
		visited = new boolean[n][n];
		
		for (int i = 0;  i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
                    visited[i][j] = true;
                    count++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = pos.x + dx[i];
				int nextY = pos.y + dy[i];
				
				if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
					if (!visited[nextX][nextY] && map[pos.x][pos.y] == map[nextX][nextY]) {
						visited[nextX][nextY] = true;
						q.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
