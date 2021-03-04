import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {	
	static boolean[] visited = new boolean[100001];
	
	static class Subin {
		int pos;
		int time;
		
		public Subin(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	bfs(n, k);
    }
    
    static void bfs(int n, int k) {
    	Queue<Subin> q = new LinkedList<>();
    	q.offer(new Subin(n, 0));
    	visited[n] = true;
    	
    	while (!q.isEmpty()) {
    		Subin cur = q.poll();
    		
    		if (cur.pos  == k) {
    			System.out.println(cur.time);
    			return;
    		}
    		
    		if (cur.pos * 2 <= 100000 && !visited[cur.pos * 2]) {
    			q.offer(new Subin(cur.pos * 2, cur.time));
    			visited[cur.pos * 2] = true;
    		}
    		
    		if (cur.pos - 1 >= 0 && !visited[cur.pos - 1]) {
    			q.offer(new Subin(cur.pos - 1, cur.time + 1));
    			visited[cur.pos - 1] = true;
    		}
    		
    		if (cur.pos + 1 <= 100000 && !visited[cur.pos + 1]) {
    			q.offer(new Subin(cur.pos + 1, cur.time + 1));
    			visited[cur.pos + 1] = true;
    		}
    	}
    }

}