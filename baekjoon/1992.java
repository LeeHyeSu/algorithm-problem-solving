import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	map = new char[N][N];
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < N; j++) {
    			map[i][j] = s.charAt(j);
    		}
    	}
    	
    	quadTree(0, 0, N);
    	
    	System.out.println(sb);
    }
    
    public static void quadTree(int r, int c, int n) {
    	if(n == 1) {
    		sb.append(map[r][c]);
    		return;
    	}
    	
    	for(int i = r; i < r+n; i++) {
    		for(int j = c; j < c+n; j++) {
    			if(map[r][c] != map[i][j]) {
    				sb.append('(');
    				quadTree(r, c, n/2);
    				quadTree(r, c+n/2, n/2);
    				quadTree(r+n/2, c, n/2);
    				quadTree(r+n/2, c+n/2, n/2);
    				sb.append(')');
    				return;
    			}
    		}
    	}
    	
    	sb.append(map[r][c]);
    	return;
    }

}