import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// N명의 사람들 중에 5명의 사람이 이어져있는지(친구인지) 확인하는 문제(DFS)
public class Main {
	static int n, m;
	static boolean[] visited;
	static ArrayList<Integer>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		
		map = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		
		for (int i = 0; i < n; i++) {
			// 시작하는 점 방문체크
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		System.out.println(0);
	}
	
	static void dfs(int idx, int depth) {
		// 문제의 조건에 맞는 A,B,C,D,E가 존재하므로 1을 출력하고 종료함
		if (depth == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (int next : map[idx]) {	
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, depth + 1);
				visited[next] = false;
			}
		}
	}

 }