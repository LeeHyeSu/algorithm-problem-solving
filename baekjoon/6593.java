import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Loc {
	int l, r, c;
	int cnt;
	
	Loc(int l, int r, int c, int cnt) {
		this.l = l;
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	static int L, R, C;
	static Loc start;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] dl = {1, 0, 0, -1, 0, 0};
	static int[] dr = {0, 1, 0, 0, -1, 0};
	static int[] dc = {0, 0, 1, 0, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String[] input = br.readLine().split(" ");
			L = Integer.parseInt(input[0]);
			R = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);
			if (L == 0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];			
			
			for (int i = 0; i < L; i++) {
				for (int j = 0 ; j < R + 1; j++) {
					String str = br.readLine();
					if (str.equals("")) break;
					
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						if (map[i][j][k] == 'S') {
							start = new Loc(i, j, k, 0);
						}
					}
				}
			}
			
			sb.append(bfs()).append('\n');
		}
		
		System.out.println(sb);
	}

	static String bfs() {
		Queue<Loc> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			Loc cur = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nl = cur.l + dl[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (!isValid(nl, nr, nc) || visited[nl][nr][nc] || map[nl][nr][nc] == '#') continue;
				
				if (map[nl][nr][nc] == 'E') {
					return "Escaped in " + (cur.cnt + 1) + " minute(s).";
				}
				
				visited[nl][nr][nc] = true;
				q.offer(new Loc(nl, nr, nc, cur.cnt + 1));
			}
		}
		
		return "Trapped!";
	}
	
	static boolean isValid(int l, int r, int c) {
		if (l < 0 || r < 0 || c < 0 || l >= L || r >= R || c >= C) {
			return false;
		}
		return true;
	}
 }