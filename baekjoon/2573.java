import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 1. 테스트 케이스 될 수 있는 한 가장 큰 수와 가장 작은 수(0)을 넣고 돌려본다 (꼭!)
	 * 2. BFS를 할 때는 큐에서 뺄 때 방문 체크를 하는 것이 아니라 큐에 넣을 때 한다. 그래야 중복 방문을 막을 수 있다!
	 */
	static int n, m;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;
	static boolean isAllMelted;
	
	static class Pair {
		int r;
		int c;
		
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 1. 빙산이 분리되어 있는지 확인
		 * 2. 분리되어 있지 않다면 계속 진행
		 * 3. 빙산이 모두 녹았다면 0을 출력하고 프로그램 종료
		 * 4. 빙산 녹이기
		 * 5. 연수(year) 증가
		 */
		int year = 0;
		while (!isSeperated()) {
			if (isAllMelted) {
				System.out.println(0);
				System.exit(0);
			}
			meltIceberg();
			year++;
		}
		 
		System.out.println(year);
	}
	
	// 빙산을 녹이는 메소드
	private static void meltIceberg() {
		// 기존 배열은 큐를 돌면서 갱신되기 때문에 기존 배열을 복사한 카피 배열을 만든다.
		int[][] copyArr = copyArray();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 빙산이라면 인접한 바다의 수를 세고 위치의 높이를 갱신한다.
				if (copyArr[i][j] > 0) {
					int countZero = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if (copyArr[nr][nc] == 0) {
							countZero++;
						}
					}
					
					arr[i][j] = (arr[i][j] - countZero < 0) ? 0 : arr[i][j] - countZero;
				}
			}
		}
	}
	
	// 빙산이 두 덩어리 이상으로 분리되어 있는지 구하는 메소드
	private static boolean isSeperated() {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		// 루프를 돌면서 빙산의 높이가 0 이상인 위치가 나오면 큐에 넣고 루프를 빠져나온다
		loop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0) {
					visited[i][j] = true;
					q.add(new Pair(i, j));
					break loop;
				}
			}
		}
		
		// 큐가 비어있다면 빙산이 모두 녹은 것으로 isAllMelted 변수를 true로 두고 리턴
		if (q.isEmpty()) {
			isAllMelted = true;
			return false;
		}
		
		// 큐에 저장된 위치의 상하좌우를 확인하고 방문한 위치를 표시
		while (!q.isEmpty()) {
			Pair pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];
				
				if (!visited[nr][nc] && arr[nr][nc] > 0) {
					visited[nr][nc] = true;
					q.add(new Pair(nr, nc));
				}
			}
		}
		
		// 빙산의 위치에 방문한 표시가 되어 있지 않다면 빙산이 분리되어 있는 것으로 true를 리턴
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0 && !visited[i][j]) return true;
			}
		}
		
		return false;
	}
	
	// 배열을 복사하는 메소드
	private static int[][] copyArray() {
		int[][] newArray = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArray[i][j] = arr[i][j];
			}
		}
		
		return newArray;
	}

}