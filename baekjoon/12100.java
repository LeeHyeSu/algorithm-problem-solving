import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, board);
		
		System.out.println(answer);
	}
	
	/*
	 * DFS + Brute-Force
	 * 블록을 상하좌우 네 방향으로 탐색하면서 
	 * count가 5가 되면 더 이상 탐색하지 않고 보드의 최댓값을 찾는다.
	 * 각 보드의 최댓값 중 가장 큰 값이 답이 된다.
	 */
	private static void solution(int count, int[][] copyBoard) {
		if (count == 5) {
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, copyBoard[i][j]);
				}
			}
			
			answer = Math.max(answer, max);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			/*
			 * 1. 상하좌우 방향으로 탐색할 수 있도록 새로운 보드(카피 보드)를 만든다.
			 * 2. 새로운 보드를 각 방향으로 움직인다.
			 * 3. 같은 값을 갖는 두 블록을 하나로 합친다.
			 * 4. 빈 자리를 없앨 수 있도록 다시 보드를 각 방향으로 움직인다.
			 * 5. 함수를 재귀 호출한다.
			 */
			int[][] newBoard = copyBoard(copyBoard);
			moveBlock(i, newBoard);
			combineBlock(i, newBoard);
			moveBlock(i, newBoard);
			solution(count + 1, newBoard);
		}
	}
	
	// 보드를 복사하여 반환하는 메소드
	private static int[][] copyBoard(int[][] oldBoard) {
		int[][] newBoard = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newBoard[i][j] = oldBoard[i][j];
			}
		}
		
		return newBoard;
	}
	
	// 같은 값을 갖는 두 블록을 하나로 합치는 메소드
	private static void combineBlock(int dir, int[][] board) {
		switch (dir) {
		case 0 :	// 상
			for (int c = 0; c < n; c++) {
				int count = 0;		// value 값을 가진 블록의 수
				int value = 0;		// 블록의 값
				for (int r = 0; r < n; r++) {
					if (count == 0) {
						value = board[r][c];
						count++;
					} else {
						/*
						 * value 값을 가진 블록의 수가 1이고 
						 * 해당 블록의 값이 value 값과 같으면 블록을 합친다
						 * 이때, 블록을 이미 이동시켰으니 인접해있는 블록과 합치는 것이 가능하다
						 * 인접해있는 블록에 새로운 값을 갱신하고 
						 * 해당 블록엔 0을 저장한다.
						 */
						if (count == 1 && value == board[r][c]) {
							board[r - 1][c] = value * 2;
							board[r][c] = 0;
							count++;
						} else {
							value = board[r][c];
							count = 1;
						}
					}
				}
			}
			return;
		case 1:		// 하
			for (int c = 0; c < n; c++) {
				int count = 0;
				int value = 0;
				for (int r = n - 1; r >= 0; r--) {
					if (count == 0) {
						value = board[r][c];
						count++;
					} else {
						if (count == 1 && value == board[r][c]) {
							board[r + 1][c] = value * 2;
							board[r][c] = 0;
							count++;
						} else {
							value = board[r][c];
							count = 1;
						}
					}
				}
			}
			return;
		case 2:		// 좌
			for (int r = 0; r < n; r++) {
				int count = 0;
				int value = 0;
				for (int c = 0; c < n; c++) {
					if (count == 0) {
						value = board[r][c];
						count++;
					} else {
						if (count == 1 && value == board[r][c]) {
							board[r][c - 1] = value * 2;
							board[r][c] = 0;
							count++;
						} else {
							value = board[r][c];
							count = 1;
						}
					}
				}
			}
			return;
		case 3:		// 우
			for (int r = 0; r < n; r++) {
				int count = 0;
				int value = 0;
				for (int c = n - 1; c >= 0; c--) {
					if (count == 0) {
						value = board[r][c];
						count++;
					} else {
						if (count == 1 && value == board[r][c]) {
							board[r][c + 1] = value * 2;
							board[r][c] = 0;
							count++;
						} else {
							value = board[r][c];
							count = 1;
						}
					}
				}
			}
			return;
		}
	}
	
	// 블록을 상(0), 하(1), 좌(2), 우(3) 네 방향 중 하나로 이동시키는 메소드
	private static void moveBlock(int dir, int[][] board) {
		switch (dir) {
		case 0 :	// 상
			for (int c = 0; c < n; c++) {
				int idx = 0;
				for (int r = 0; r < n; r++) {
					if (board[r][c] == 0) {
						idx++;
					}
					else {
						board[r - idx][c] = board[r][c];
						if (idx != 0) board[r][c] = 0;
					}
				}
			}
			return;
		case 1:		// 하
			for (int c = 0; c < n; c++) {
				int idx = 0;
				for (int r = n - 1; r >= 0; r--) {
					if (board[r][c] == 0) {
						idx++;
					}
					else {
						board[r + idx][c] = board[r][c];
						if (idx != 0) board[r][c] = 0;
					}
				}
			}
			return;
		case 2:		// 좌
			for (int r = 0; r < n; r++) {
				int idx = 0;
				for (int c = 0; c < n; c++) {
					if (board[r][c] == 0) {
						idx++;
					}
					else {
						board[r][c - idx] = board[r][c];
						if (idx != 0) board[r][c] = 0;
					}
				}
			}
			return;
		case 3:		// 우
			for (int r = 0; r < n; r++) {
				int idx = 0;
				for (int c = n - 1; c >= 0; c--) {
					if (board[r][c] == 0) {
						idx++;
					}
					else {
						board[r][c + idx] = board[r][c];
						if (idx != 0) board[r][c] = 0;
					}
				}
			}
			return;
		}
	}

}  