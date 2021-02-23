import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int[] arr, perm;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		perm = new int[N];
		visited = new boolean[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	static void dfs(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(perm[i] - perm[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			perm[depth] = arr[i];
			dfs(depth + 1);
			visited[i] = false;
		}
	}
	
}  