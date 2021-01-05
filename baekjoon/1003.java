import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int[][] fib;
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		fib = new int[N+1][2];
    		fibonacci(N);
    		sb.append(fib[N][0]).append(' ').append(fib[N][1]).append('\n');
    	}
    	
    	System.out.println(sb);
    }
    
    static void fibonacci(int n) {
    	if(n <= 1) {
    		fib[n][n]++;
    	} else {
    		if(fib[n-1][0] == 0 && fib[n-1][1] == 0) fibonacci(n-1);
    		if(fib[n-2][0] == 0 && fib[n-2][1] == 0) fibonacci(n-2);
    		
    		fib[n][0] += fib[n-1][0] + fib[n-2][0];
    		fib[n][1] += fib[n-1][1] + fib[n-2][1];
    	}
    }

}