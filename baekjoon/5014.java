import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int[] floor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());	// 건물의 총 층수 
		S = Integer.parseInt(st.nextToken());	// 강호가 지금 있는 층
		G = Integer.parseInt(st.nextToken());	// 스타트링크가 있는 층
		U = Integer.parseInt(st.nextToken());	// 위로 U층을 가는 버튼
		D = Integer.parseInt(st.nextToken());	// 아래로 D층을 가는 버튼
		
		floor = new int[F + 1];
		if (S == G) System.out.println(0);	// 강호가 지금 있는 층이 스타트링크가 있는 층일 때
		else System.out.println(bfs());
	}
	
	static String bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);	// 큐에 현재 층 넣기
		floor[S] = 1;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			int up = current + U;
			int down = current - D;
			
			if (up == G || down == G) {
				return String.valueOf(floor[current]);
			}
			
			if (up <= F && floor[up] == 0) {
				floor[up] = floor[current] + 1;
				q.add(up);
			}
			
			if (down > 0 && floor[down] == 0) {
				floor[down] = floor[current] + 1;
				q.add(down);
			}
		}
		
		return "use the stairs";
	}

}