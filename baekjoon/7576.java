import java.io.*;
import java.util.*;

public class Main {
	static int m, n;
	static int[][] box;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		/*
		 * 토마토
		 * 토마토가 익은 점들을 큐에 넣어준다.
		 * 익은 토마토를 상하좌우 탐색하며 익지 않은 토마토가 있으면 그 위치를 큐에 넣어준다.
		 * (그 위치의 값은 최대 일수를 계산하기 위해 전 위치 +1 을 해준다.)
		 * 전체 토마토들을 탐색하여 익지않은 토마토(0 값) 하나라도 있으면 -1를 출력한다.
		 * 그 외는 최대 일수를 출력한다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());		// 가로(열)
		n = Integer.parseInt(st.nextToken());		// 세로(행)
		box = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int day = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				
				day = Math.max(day, box[i][j]);
			}
		}
		
		System.out.println(day - 1);	// 1부터 시작하므로 1 빼주기
	}

	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					q.add(new Pair(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				Pair temp = new Pair(pos.x + dx[i], pos.y + dy[i]);
				
				if (temp.x >= 0 && temp.y >= 0 && temp.x < n && temp.y < m) {
					if (box[temp.x][temp.y] == 0) {
						box[temp.x][temp.y] = box[pos.x][pos.y] + 1;
						q.add(temp);
					}
				}
			}
		}
	}
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}