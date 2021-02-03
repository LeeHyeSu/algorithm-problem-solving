import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	/*
	 * 숨바꼭질 
	 * 큐에 해당 위치를 넣어주고 check[현재위치]의 값을 1로 변경한다.
	 * 큐가 비지않을 동안 while문을 돌면서 다음에 갈 위치(next)를 변경한다.
	 * next가 범위안에 있고 이전에 방문한 이력이 없으면 큐에 넣어준다.
	 * (BFS를 수행하기 전에 N과 K가 같을 때 0으로 출력해줘야함)
	 */
	static int n, k;
	static int[] check = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		if (n == k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		check[num] = 1;
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) {
					next = pos + 1;
				} else if (i == 1) {
					next = pos - 1;
				} else {
					next = pos * 2;
				}
				
				if (next == k) {
					System.out.println(check[pos]);
					return;
				}
				
				if (next >= 0 && next < check.length && check[next] == 0) {
					q.add(next);
					check[next] = check[pos] + 1;
				}
			}
		}
	}

}
