import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// color 배열 하나만 두어 visited 배열까지 대체함
public class Main {
	static int n, m;
	static int[] color;	// 서로 다른 영역의 노드는 1과 -1로 나타내고 0이면 방문하지 않은 노드를 나타냄
	static List<List<Integer>> graph;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			color = new int[n + 1];
			ans = true;
			
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			for (int i = 1; i <= n; i++) {
				if (color[i] == 0) {
					color[i] = 1;
					bfs(i);
				}
			}
			
			if (ans) sb.append("YES");
			else sb.append("NO");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		while (!q.isEmpty()) {
			int x = q.poll();

			for (int v : graph.get(x)) {
				if (color[v] == 0) {
					if (color[x] == 1) color[v] = -1;
					else color[v] = 1;
					q.add(v);
				} else {
					if (color[x] == color[v]) {
						ans = false;
						return;
					}
				}
			}
		}`
	}
 }