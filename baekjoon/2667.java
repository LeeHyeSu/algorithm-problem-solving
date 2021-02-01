import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;				// 지도 배열
	static boolean[][] visited;		// 방문 체크 배열
	static int count = 0;			// 집의 개수 

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N+2][N+2];			// 끝단 처리할 필요 없게 N+2 로 배열 크기 지정 
    	visited = new boolean[N+2][N+2];
    	
    	for (int i = 1; i <= N; i++) {
    		String[] str = br.readLine().split("");
    		for (int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(str[j - 1]);
    		}
    	}
    	
    	List<Integer> complexes = new ArrayList<>();	// 단지수 리스트
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= N; j++) {
    			// 집이 있고 방문하지 않은 곳이라면 위아래좌우 연결된 집이 있는지 확인
    			if (!visited[i][j] && map[i][j] == 1) {		
    				dfs(i, j);
    				complexes.add(count);	// 연결된 집의 수를 단지에 add 
    				count = 0;				// count 초기화
    			}
    		} 
    	}
    	
    	Collections.sort(complexes);	// 오름차수 정렬
    	
    	System.out.println(complexes.size());
    	for (int complex : complexes) {
    		System.out.println(complex);
    	}
    }
    
    static void dfs(int i, int j) {
    	if (visited[i][j] || map[i][j] == 0) {	// 집이 없거나 이미 방문한 곳이라면 return
    		return;
    	}
    	
    	visited[i][j] = true;
    	count++;
    	
    	dfs(i - 1, j);		// 위 ↑
    	dfs(i + 1, j);		// 아래↓
    	dfs(i, j - 1);		// 왼쪽←
    	dfs(i, j + 1);		// 오른쪽→
    }
}