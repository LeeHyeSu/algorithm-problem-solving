import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	int[][] A = new int[N][N];
    	long B = Long.parseLong(st.nextToken());

    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			A[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[][] res = solution(A, B);
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			sb.append(res[i][j] % 1000).append(' ');
    		}
    		sb.append('\n');
    	}
    	
    	System.out.println(sb);
    }
    
    static int[][] square(int[][] a, int[][] A) {
    	int[][] temp = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			for (int k = 0; k < N; k++) {
    				temp[i][j] += a[i][k] * A[k][j];
    			}
    			temp[i][j] %= 1000;
    		}
    	}
    	
    	return temp;
    }
    
    static int[][] solution(int[][] a, long b) {
    	if (b == 1) {
    		return a;
    	} else if (b % 2 == 0){
    		int[][] temp = solution(a, b/2);
    		return square(temp, temp);
    	} else {
    		return square(solution(a, b-1), a);
    	}
    }
 
}