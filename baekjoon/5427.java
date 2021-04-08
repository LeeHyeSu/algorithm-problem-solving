import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;
	char type;	// '@': 상근이, '*': 불
	int count;
	
	public Point(int y, int x, char type, int count) {
		this.y = y;
		this.x = x;
		this.type = type;
		this.count = count;
	}
}

public class Main {
	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	static Point sg;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];
			Queue<Point> q = new LinkedList<>();
			int ans = 0;
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					
					if (map[i][j] == '@') {
						sg = new Point(i, j, '@', 1);
						visited[i][j] = true;
					} 
					else if (map[i][j] == '*') {
						q.offer(new Point(i, j, '*', 0));
					}
				}
			}
			q.offer(sg);
			
			if (isEdge(sg.y, sg.x)) ans = 1;	// 가장자리에서 시작한다면 바로 탈출가능
			else ans = bfs(q);
			
			if (ans == -1) sb.append("IMPOSSIBLE");
			else sb.append(ans);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(Queue<Point> q) {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (cur.type == '@') {	// 상근이
					if (visited[ny][nx] || map[ny][nx] != '.') continue;
					
					if (isEdge(ny, nx)) {
						return cur.count + 1;
					} 
					
					visited[ny][nx] = true;
					q.add(new Point(ny, nx, '@', cur.count + 1));
				}
				else {	// 불
					if (!isValid(ny, nx) ||
							map[ny][nx] == '#' ||  map[ny][nx] == '*') continue;
					
					map[ny][nx] = '*';
					q.add(new Point(ny, nx, '*', 0));
				}
			}
		}
		
		return -1;
	}

	// 해당 위치가 범위 안에 있는지 체크하는 메소드
	private static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= h || x >= w) {
			return false;
		}
		return true;
	}

	// 가장자리인지 확인하는 메소드 - 동서남북 방향으로 위치를 확인해서 하나라도 범위 안에 있지 않는 경우
	private static boolean isEdge(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!isValid(ny, nx)) return true;
		}
		return false;
	}

}