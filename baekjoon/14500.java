import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 'ㅗ'를 제외한 'ㅁ' ,'ㄱ', 'ㅡ' 등의 모형들은 DFS로 한번에 가능하다.
 * 2. 'ㅗ' 모형은 ㅗ, ㅓ, ㅏ, ㅜ 로 돌아갈 수 있기 때문에 '+'에서 날개 하나를 빼는 식으로 구현한다.
 */
public class Main {
	static int N, M, max = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				specialShape(i, j);
			}
		}
		
		System.out.println(max);
	}

	// 'ㅁ' ,'ㄱ', 'ㅡ' 등의 모양 구현
	public static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= M
					|| visited[nx][ny]) {
				continue;
			}
			
			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	// 'ㅗ' 모양 구현 ( + 모양에서 하나를 뺌 )
	public static void specialShape(int x, int y) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 날개가 2개 이상 없다면 'ㅗ' 모양이 아니므로 함수 종료
			if (wing <= 2) return;
			
			// 날개가 맵 바깥에 있다면 날개가 아님
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}
		
		// 날개가 4개일 때 가장 작은 날개를 없애야 ㅗ, ㅏ, ㅓ, ㅜ 모양이 나옴
		if (wing == 4) {
			sum = sum - min;
		}
		
		max = Math.max(max, sum);
	}
}  