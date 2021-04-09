import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;
	
	static class Point {
		int y;
		int x;
		int count;	// 섬을 연결하는 다리의 길이
		
		Point(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// BFS를 이용하여 각 섬에 번호를 붙여준다
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					map[i][j] = num;
					bfs(i, j, num++);
				}
			}
		}

		// 섬의 가장자리인 경우, 다른 섬과의 거리를 구하는 dist함수를 호출한다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					boolean isEdge = false;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if (!isValid(ny, nx) || map[ny][nx] != 0) continue;
						
						isEdge = true;
						break;
					}
					
					if (isEdge) {
						dist(i, j, map[i][j]);
						visited = new boolean[N][N];
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	// 다른 섬과의 거리를 구하는 함수
	static void dist(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x, 0));
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				// map[ny][nx] == num 이면 같은 섬이므로 skip
				if (!isValid(ny, nx) || visited[ny][nx] || map[ny][nx] == num) continue;
				
				if (map[ny][nx] != 0) {	// 바다가 아닌 다른 섬이므로 거리를 갱신하고 return
					ans = Math.min(ans, cur.count);
					return;
				}
				
				visited[ny][nx] = true;
				q.add(new Point(ny, nx, cur.count + 1));
			}
		}
	}
	
	// 섬에 번호를 부여하는 함수
	static void bfs(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x, 0));
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (!isValid(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
				
				visited[ny][nx] = true;
				map[ny][nx] = num;
				q.add(new Point(ny, nx, 0));
			}
		}
	}
	
	// 위치가 범위 안에 있는지 확인하는 함수
	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}
		return true;
	}

}