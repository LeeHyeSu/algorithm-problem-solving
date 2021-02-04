import java.io.*;
import java.util.*;

public class Main {
	static int l;
	static int[][] board;
	static boolean[][] visited;
	static Pair start, end;
	static int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
	static int[] dy = {-1, -2, 1, 2, -2, -1, 2, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t > 0) {
			l = Integer.parseInt(br.readLine());
			board = new int[l][l];
			visited = new boolean[l][l];
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			start = new Pair(x, y);
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			end = new Pair(x, y);

			bfs();
			
			sb.append(board[end.x][end.y]).append('\n');
			
			t--;
		}
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;
		
		while (!q.isEmpty()) {
			Pair pos = q.poll();
			
			if (pos.x == end.x && pos.y == end.y) {
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nextX = pos.x + dx[i];
				int nextY = pos.y + dy[i];
				
				if (nextX >= 0 && nextY >= 0 && nextX < l && nextY < l) {
					if (!visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						board[nextX][nextY] = board[pos.x][pos.y] + 1;
						q.add(new Pair(nextX, nextY));
					}
				}
			}
		}
	}
	
	static class Pair {
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}