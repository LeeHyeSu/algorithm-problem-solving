import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 1. 입력을 받으면서 지훈이의 좌표는 따로 저장해두고, 불인 경우는 queue에 넣어 준다.
	 * ( 큐에 불 - 지훈의 순서로 넣는 이유는?
	 * 		-> 불에 탈 수 있는 공간에 지훈이를 위치시키면 안되기 때문에 불을 먼저 확산시키고 지훈 이동)
	 * 2. bfs()를 수행한다.
	 *   ◦ 네 방향으로 이동하면서 범위를 벗어나거나, 벽이거나, 불인 경우는 이동할 수 없으니 continue
	 *   ◦ 다음 방문할 좌표가 !visited[nx][ny] (이전에 방문 X)이고 지훈(p.type = 0)이면 q에 넣어준다.
	 *   ◦ 불인 경우는 maze에 바로 불이 확산됨을 표시해서 방문체크를 할 수 있도록 한다.
	 */
	static int r, c;
	static char[][] maze;
	static boolean[][] visited;
	static Point jihun;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Point {
		int x;
		int y;
		int type;	// 0 : 지훈 , 1 : 불
		int count;	// 이동한 시간
		
		public Point(int x, int y, int type, int count) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		maze = new char[r][c];
		visited = new boolean[r][c];
		
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (maze[i][j] == 'J') {
					// 시작점에서 바로 탈출 가능한 경우(가장자리에 있음)
					if (isEdge(i, j)) {
						System.out.println(1);
						return;
					}
					
					maze[i][j] = '.';
					jihun = new Point(i, j, 0, 0);
				} else if (maze[i][j] == 'F') {
					q.add(new Point(i, j, 1, 0));
				}
			}
		}
		
		bfs(q);
	}

	static void bfs(Queue<Point> q) {
		int x;
		int y;
		int count;
		
		q.add(jihun); // 불 - 지훈의 순서로 queue에 넣어줌
		visited[jihun.x][jihun.y] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			count = p.count;
			
			// 종료 조건(지훈이 가장자리에 있을 때)
			if (isEdge(x, y) && p.type == 0) {
				System.out.println(count + 1);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (!isRange(nx, ny) || maze[nx][ny] == '#' || maze[nx][ny] == 'F') {
					continue;
				}
				
				if (p.type == 0 && !visited[nx][ny]) {
					// 지훈
					q.add(new Point(nx, ny, p.type, count + 1));
					visited[nx][ny] = true;
				} else if (p.type == 1) {
					// 불
					maze[nx][ny] = 'F';
					q.add(new Point(nx, ny, p.type, count + 1));
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
	
	// 입력받은 좌표가 maze의 범위 내에 있는지 판별
	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) {
			return true;
		}
		return false;
	}
	
	// 입력받은 좌표가 미로의 가장자리인지 판별
	static boolean isEdge(int x, int y) {
		// 네 방향으로 이동시켰을 때 미로의 범위를 넘어가면 가장자리인 것
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!isRange(nx, ny)) {
				return true;
			}
		}
		
		return false;
	}
	
}