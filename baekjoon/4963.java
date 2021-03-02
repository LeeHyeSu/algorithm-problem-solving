import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int count;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1, -1, -1, 1, 1};
	static int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String s = br.readLine();
		while (!s.equals("0 0")) {
			st = new StringTokenizer(s);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
			s = br.readLine();
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 || ny >= h || nx >= w 
					|| map[ny][nx] == 0 || visited[ny][nx]) continue;
			
			dfs(ny, nx);
		}
	}

 }