import java.io.*;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[][] C = new int[N+1][N+1];
    	
    	for (int i = 0; i <= N; i++) {
    		for (int j = 0; j <= i; j++) {
    			if (j == 0 || j == i) {
    				C[i][j] = 1;
    			} else {
    				C[i][j] = (C[i-1][j-1] + C[i-1][j]) % 10007;
    			}
    		}
    	}
    	
    	System.out.println(C[N][K]);
    }
    
}