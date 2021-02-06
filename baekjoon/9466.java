import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;		// 방문 여부 체크
	static boolean[] finished;		// 방문한 노드에서 이미 탐색한 싸이클이 존재하는 지 확인
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T > 0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			
			// n - count : 전체 노드의 수 - 싸이클을 이룬 노드의 수
			sb.append(n - count).append('\n');
			
			T--;
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int now) {
		if (visited[now]) {
			return;
		}
		
		visited[now] = true;
		int next = arr[now];
		
		/*
		 * 다음 노드를 방문하지 않았다면 재귀 호출
		 * 방문했다면 싸이클을 탐색했던 노드인지 확인
		 */
		if (!visited[next]) {	
			dfs(next);
		} else {
			/*
			 * 싸이클을 탐색했던 노드가 아니라면 싸이클의 길이 구하기
			 * 노드가 끝나려면 무조건 싸이클을 거쳐야함
			 * 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 항상 싸이클이 존재
			 */
			if (!finished[next]) {
				count++;
				for (int i = next; i != now; i = arr[i]) {
					count++;
				}
			}
		}
		
		// 싸이클이 종료됨
		finished[now] = true;
	}

}
