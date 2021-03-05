import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cost = cnt;
		}

		@Override
		public int compareTo(Point target) {
			return this.cost - target.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = row[j] - '0';
			}
		}
		
		bfs();
	}
	
	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.x == N - 1 && p.y == M - 1) {
				System.out.println(p.cost);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx <  0|| ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
		
				if (map[nx][ny] == 1) pq.offer(new Point(nx, ny, p.cost + 1));
				else pq.offer(new Point(nx, ny, p.cost));
				
				visited[nx][ny] = true;
			}
		}
	}
 }