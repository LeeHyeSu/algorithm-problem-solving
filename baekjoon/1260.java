import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int V = Integer.parseInt(st.nextToken());

    	for (int i = 0; i <= N; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		graph.get(x).add(y);
    		graph.get(y).add(x);
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		Collections.sort(graph.get(i));
    	}
    	
    	visited = new boolean[N+1];
    	dfs(V);
    	System.out.println();
    	
    	visited = new boolean[N+1];
    	bfs(V);
    	System.out.println();
    }
    
    public static void dfs(int v) {
    	if (visited[v]) {
    		return;
    	}
    	
    	visited[v] = true;
    	System.out.print(v + " ");
    	
    	for (int n : graph.get(v)) {
    		if (!visited[n]) {
    			dfs(n);
    		}
    	}
    }
    
    public static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(start);
    	
    	visited[start] = true;
    	
    	while (!q.isEmpty()) {
    		int v = q.poll();
    		System.out.print(v + " ");
    		
    		for (int n : graph.get(v)) {
    			if (!visited[n]) {
    				visited[n] = true;
    				q.offer(n);
    			}
    		}
    	}
    }
    
}