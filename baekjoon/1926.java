import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int count = 0;
	static int area = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && paper[i][j] == 1) {
					count++;
					dfs(i, j);
					max = Math.max(max, area);
					area = 0;
				}
			}
		}
		
		System.out.println(count + "\n" + max);
	}
	
	static void dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return;
		}
		
		if (visited[i][j] || paper[i][j] == 0) {
			return;
		}
		
		visited[i][j] = true;
		area++;
		
		dfs(i - 1, j);
		dfs(i, j - 1);
		dfs(i + 1, j);
		dfs(i, j + 1);
	}

}
