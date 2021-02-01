import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	maze = new int[N][M];
    	visited = new boolean[N][M];

    	for (int i = 0; i < N; i++) {
    		String s = br.readLine();
    		for (int j = 0; j < M; j++) {
    			maze[i][j] = s.charAt(j) - '0';
    		}
    	}
    	
    	bfs();

    	System.out.println(maze[N-1][M-1]);
    }
    
    public static void bfs() {
    	Queue<Location> q = new LinkedList<>();
    	q.add(new Location(0, 0));

    	while (!q.isEmpty()) {
    		Location loc = q.poll();
    		visited[loc.x][loc.y] = true;
    		
    		for (int i = 0; i < 4; i++) {
    			int nx = loc.x + dx[i];
    			int ny = loc.y + dy[i];
    			
    			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
    				if (!visited[nx][ny] && maze[nx][ny] == 1) {
    					q.add(new Location(nx, ny));
    					visited[nx][ny] = true;
    					maze[nx][ny] = maze[loc.x][loc.y] + 1;
    				}
    			}
    		}
    	}
    }

}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}