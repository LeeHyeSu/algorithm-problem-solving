import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map;
	static boolean[][] check;
	static int count;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	while (T > 0) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	M = Integer.parseInt(st.nextToken());
	    	N = Integer.parseInt(st.nextToken());
	    	int K = Integer.parseInt(st.nextToken());
	    	
	    	map = new int[N][M];
	    	check = new boolean[N][M];
	    	count = 0;
	    	
	    	for (int i = 0; i < K; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		int y = Integer.parseInt(st.nextToken());
	    		int x = Integer.parseInt(st.nextToken());
	    		
	    		map[x][y] = 1;
	    	}
	    	
	    	for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < M; j++) {
	    			if (!check[i][j] && map[i][j] == 1) {
	    				dfs(i, j);
	    				count++;
	    			}
	    		}
	    	}
	    	
	    	sb.append(count).append('\n');
	    	T--;
    	}
    	
    	System.out.println(sb);
    }

    public static void dfs(int x, int y) {
    	check[x][y] = true;
    	
    	for (int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
    			if (!check[nx][ny] && map[nx][ny] == 1) {
        			dfs(nx, ny);
        		}
    		}
    	}
    }

}