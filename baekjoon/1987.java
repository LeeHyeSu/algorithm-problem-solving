import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans = 0;
	static int[][] board;
	static boolean[] visited = new boolean[26]; 	// 알파벳 중복을 확인하는 배열
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j) - 'A';	// (A -> 0, B -> 1, ...)
			}
		}
		
		visited[board[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}

	static void dfs(int x, int y, int count) {
		ans = Math.max(ans, count);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			
			int alpha = board[nx][ny];
			if (!visited[alpha]) {
				visited[alpha] = true;
				dfs(nx, ny, count + 1);
				visited[alpha] = false;
			}
		}
	}
}