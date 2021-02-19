import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static int[][] note;
	
	static class Sticker {
		int r;
		int c;
		int[][] shape;
		
		public Sticker(int r, int c, int[][] shape) {
			this.r = r;
			this.c = c;
			this.shape = shape;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		note = new int[n][m];
		List<Sticker> stickers = new ArrayList<>();
		
		while (k > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] shape = new int[r][c];
			
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					shape[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			stickers.add(new Sticker(r, c, shape));
			
			k--;
		}
		
		int count = 0;
		
		/* 
		 * 1. 스티커를 순서대로 노트북에 붙일 수 있는 위치를 찾는다.
		 * 2. 노트북에 붙일 수 없다면 스티커를 회전시키고 다시 위치를 찾는다.
		 * 3. 스티커를 시계방향으로 90도 3번 회전시켜도 노트북에 붙일 수 없다면 버리고 다음 스티커로 넘어간다.
		 */
		for (Sticker sticker : stickers) {
			int dir = 0;
			while (!checkPosition(0, 0, sticker)) {
				if (dir++ >= 3) break;
				sticker = turnSticker(sticker);
			}
		}
		
		// 노트북에 스티커가 붙어있는 칸의 갯수을 센다.
		for (int[] row : note) {
			for (int value : row) {
				count += value;
			}
		}
		
		System.out.println(count);
	}

	/*
	 * 노트북에 스티커를 붙일 수 있는 위치를 찾고 스티커를 붙이는 메소드
	 * 스티커를 붙일 수 있는 위치가 아니라면 재귀적으로 함수를 호출하거나 false를 반환
     * 스티커를 붙일 수 있는 위치가 나오면 스티커를 붙이고 true를 반환
	 */
	private static boolean checkPosition(int r, int c, Sticker sticker) {

		if (r + sticker.r > n || c + sticker.c > m) return false;
	
		boolean checked = true;
		
		for (int i = r; i < r + sticker.r; i++) {
			for (int j = c; j < c + sticker.c; j++) {			
				if (checked && note[i][j] == 1 && sticker.shape[i - r][j - c] == 1) {
					if (c + sticker.c < m) {
						checked = checkPosition(r, c + 1, sticker);
					} else {
						checked = checkPosition(r + 1, 0, sticker);
					}
					
					return checked;
				}
			}
		}
		
		if (checked) {
			for (int i = r; i < r + sticker.r; i++) {
				for (int j = c; j < c + sticker.c; j++) {			
					if (note[i][j] == 0 && sticker.shape[i - r][j - c] == 1) {
						note[i][j] = 1;
					}
				}
			}
		}
		
		return checked;
	}
	
	// 스티커를 시계 방향으로 90도 회전시키는 메소드 
	private static Sticker turnSticker(Sticker sticker) {
		
		int[][] newShape = new int[sticker.c][sticker.r];
		
		for (int i = 0; i < sticker.r; i++) {
			for (int j = 0; j < sticker.c; j++) {
				newShape[j][i] = sticker.shape[sticker.r - 1 - i][j];
			}
		}
		
		return new Sticker(sticker.c, sticker.r, newShape);
	}
}