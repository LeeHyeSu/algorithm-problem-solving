import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] w;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			TSP(i, i, 0, 0);
			visited[i] = false;
		}
		
		System.out.println(min);
	}

	static void TSP(int start, int city, int cost, int count) {
		if (count == n-1) {
			if (w[city][start] != 0) {
				cost += w[city][start]; 
				min = Math.min(min, cost);
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i] && w[city][i] != 0) {
				visited[i] = true;
				TSP(start, i, cost + w[city][i], count + 1);
				visited[i] = false;
			}
		}
	}
}  