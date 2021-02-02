import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n, h;
	static int[][][] board;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());		// 가로(열)
		n = Integer.parseInt(st.nextToken());		// 세로(행)
		h = Integer.parseInt(st.nextToken());		// 상자의 수(높이)
		
		board = new int[n][m][h];
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		int day = 0;
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j][k] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
					
					day = Math.max(day, board[i][j][k]);
				}
			}
		}
		
		System.out.println(day - 1);
	}

	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j][k] == 1) {
						q.add(new Pair(i, j, k));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair pos = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nextX = pos.x + dx[i];
				int nextY = pos.y + dy[i];
				int nextZ = pos.z + dz[i];
				
				if (nextX >= 0 && nextY >= 0 && nextZ >= 0
						&& nextX < n && nextY < m && nextZ < h) {
					if (board[nextX][nextY][nextZ] == 0) {
						board[nextX][nextY][nextZ] = board[pos.x][pos.y][pos.z] + 1;
						q.add(new Pair(nextX, nextY, nextZ));
					}
				}
			}
		}
	}
	
	static class Pair {
		int x;
		int y;
		int z;
		
		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}