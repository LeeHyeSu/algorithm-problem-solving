import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 1. class 선언 시 필요한 정보를 변수로 만들기
	 * 2. 방문 배열을 boolean이 아닌 int형으로 만들고 MAX로 초기화 시켜두기
	 * 3. BFS안에서 상하좌우 체크하며 이동, 방문 배열의 최소 값을 계속 가져가야 함
	 */
	static int n, m, result;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static class Point {
		int x;
		int y;
		int dist;	// 이동 거리
		int drill;	// 공사 횟수
		
		public Point(int x, int y, int dist, int drill) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.drill = drill;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[j] - '0';
				visited[i][j] = Integer.MAX_VALUE;		// MAX로 초기화
			}
		}
		
		bfs(0, 0);
		
		if (result == 0) System.out.println(-1);
		else System.out.println(result);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 1, 0));
		visited[x][y] = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			// 도착지점 만나면 종료
			if (p.x == n - 1 && p.y == m - 1) {
				result = p.dist;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				/*
				 * visited 배열의 값은 공사 횟수를 나타내므로,
				 * 만약 다음에 나온 공사 횟수 값이 기존에 갖고 있던 값보다 작거나 같으면 넘어감
				 */
				if (visited[nx][ny] <= p.drill) continue;
				
				if (map[nx][ny] == 0) {	// 벽이 아닐 때 : 이동거리 + 1
					visited[nx][ny] = p.drill;
					q.add(new Point(nx, ny, p.dist+1, p.drill));
				} else {				// 벽일 때 : 공사 횟수 = 0 이면 이동거리 + 1, 공사 횟수 + 1
					if (p.drill == 0) {
						visited[nx][ny] = p.drill + 1;
						q.add(new Point(nx, ny, p.dist+1, p.drill+1));
					}
				}
			}
		}
	}

}