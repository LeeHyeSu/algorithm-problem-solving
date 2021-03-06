import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> q = new LinkedList<>();
	
	static class Point {
		int r;
		int c;
		char type;
		int time;
		
		public Point() {}
		
		public Point(int x, int y, char type, int time) {
			this.r = x;
			this.c = y;
			this.type = type;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		
		Point hedgehog = new Point();		// 고슴도치의 위치
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				/*
				 * 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없으므로
				 * 물을 먼저 큐에 넣어서 이동시킨 다음 고슴도치가 움직이도록 한다.
				 * 물 -> 고슴도치 -> 물 -> 고슴도치
				 */
				if (map[i][j] == '*') {
					q.offer(new Point(i, j, '*', 0));
				} 
				
				if (map[i][j] == 'S') {
					hedgehog = new Point(i, j, 'S', 0);
					visited[i][j] = true;
				}
			}
		}
		
		q.offer(hedgehog);
		
		bfs();
		
		System.out.println("KAKTUS");
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				
				if (!visited[nr][nc] && cur.type == 'S') {
					// 고슴도치가 비버의 굴에 도착했을 때 걸린 시간을 출력하고 프로그램 종료
					if (map[nr][nc] == 'D') {
						System.out.println(cur.time + 1);
						System.exit(0);
					}
					
					if (map[nr][nc] == '.') {
						q.offer(new Point(nr, nc, cur.type, cur.time + 1));
						visited[nr][nc] = true;		// 고슴도치가 이동할 구역 방문 체크 (안하면 메모리 초과)
					}
				} else if (cur.type == '*') {
					if (map[nr][nc] == '.') {
						map[nr][nc] = '*';
						q.offer(new Point(nr, nc, cur.type, cur.time + 1));
					}
				}
			}
		}
	}
 }