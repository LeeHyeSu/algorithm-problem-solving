import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int answer = bfs(n, m, maps, visited);
        return answer;
    }
    
    int bfs(int n, int m, int[][] maps, boolean[][] visited) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Pos p = q.poll();
            
            if (p.y == n-1 && p.x == m-1) {
                return p.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx] || maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = true;
                q.offer(new Pos(ny, nx, p.count + 1));
            }
        }
        
        return -1;
    }
}

class Pos {
    int y, x;
    int count;
    
    Pos(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}