import java.io.*;
import java.util.*;

public class Main {
	static int n, m;		// 세로, 가로
	static int blindSpots, cctvCnt;		// 사각 지대의 수, CCTV의 수
	static List<CCTV> cctvs;
	static int[] dr = {-1, 0, 1, 0};		// r 방향
	static int[] dc = {0, 1, 0, -1};		// c 방향
	static int[][][] dir = {		// 각 CCTV가 볼 수 있는 영역
			{{0}},
			{{1}, {2}, {3}, {0}},	// 1번 CCTV
			{{1, 3}, {0, 2}},		// 2번 CCTV
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},		// 3번 CCTV
			{{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},	// 4번 CCTV
			{{0, 1, 2, 3}}			// 5번 CCTV
	};
	
	static class CCTV {
		int r;
		int c;
		int type;
		
		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		cctvs = new ArrayList<>();
		
		int remain = n * m;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// CCTV일 경우
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
				// 벽일 경우
				else if (map[i][j] == 6) {
					remain--;
				}
			}
		}

		blindSpots = Integer.MAX_VALUE;
		cctvCnt = cctvs.size();
		
		monitoring(0, remain - cctvCnt, map);
		
		System.out.println(blindSpots);
		
	}

	private static void monitoring(int idx, int remain, int[][] map) {
		
		// 모든 CCTV의 감시 영역을 확인했다면
		if (idx == cctvCnt) {
			blindSpots = Math.min(blindSpots, remain);
			return;
		}
		
		int[][] newMap = new int[n][m];
		copy(newMap, map); 
		
		// 각 CCTV를 확인
		CCTV c = cctvs.get(idx);
		
		// 해당 CCTV가 90도씩 회전하며 감시
		for (int i = 0; i < dir[c.type].length; i++) {
			int check = 0;
			// 현재 상태에서 감시할 수 있는 방향으로 감시
			for (int j = 0; j < dir[c.type][i].length; j++) {
				int d = dir[c.type][i][j];
				check += observation(c.r, c.c, d, newMap);
			}
			
			monitoring(idx + 1, remain - check, newMap);
			// 다른 방향으로도 확인해보기 위해 map 상태를 되돌림
			copy(newMap, map);
		}
		
	}

	private static int observation(int r, int c, int d, int[][] map) {

		// 감시할 수 있는 영역의 수
		int cnt = 0;
		
		while (true) {
			r += dr[d];
			c += dc[d];
			
			// 범위를 벗어나거나 벽이 있다면
			if (r < 0 || r >= n || c < 0 || c >= m || map[r][c] == 6) return cnt;
			
			// 다른 CCTV가 있거나 이미 감시된 영역일 경우 pass
			if (map[r][c] >= 1 && map[r][c] <= 5 || map[r][c] == -1) continue;
			
			// 빈 칸일 경우, 감시 된 영역임을 표시
			map[r][c] = -1;
			cnt++;
		}
		
	}

	private static void copy(int[][] newMap, int[][] map) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
	}

}  