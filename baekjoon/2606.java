import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int count = 0;

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());	// 컴퓨터의 수 
    	int m = Integer.parseInt(br.readLine());	// 직접 연결되어 있는 컴퓨터 쌍의 수
    	for (int i = 0; i <= n; i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	
    	for (int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		graph.get(x).add(y);
    		graph.get(y).add(x);
    	}
    	
    	visited = new boolean[n+1];
    	visited[1] = true;
    	
    	bfs();
    
    	System.out.println(count);
    }
    
    public static void bfs() {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	
    	while(!q.isEmpty()) {
    		int node = q.poll();
    		for (int v : graph.get(node)) {
    			if (!visited[v]) {
    				visited[v] = true;
    				q.add(v);
    				count++;
    			}
    		}
    	}
    }
    
}