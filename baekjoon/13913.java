import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int N, K;
	static int[] parent = new int[100001];	// 이전 경로
	static int[] time = new int[100001]; 	// 각 위치에 도달했을 때의 시간

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
	
		bfs();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int index = K;
		
		while (index != N) {
			stack.push(parent[index]);
			index = parent[index];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(time[K] - 1).append('\n');
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		time[N] = 1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == K) return;
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) next = now + 1;
				else if (i == 1) next = now - 1;
				else next = now * 2;
				
				if (next < 0 || next > 100000) continue;
				
				if (time[next] == 0) {
					q.offer(next);
					time[next] = time[now] + 1;
					parent[next] = now;
				}
			}
		}
	}
 }