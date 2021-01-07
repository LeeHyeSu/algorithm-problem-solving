import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	long[] P = new long[101];
    	P[1] = P[2] = P[3] = 1;
    	
    	for(int i = 4; i <= 100; i++) {
    		P[i] = P[i-2] + P[i-3];
    	}
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		sb.append(P[N]).append('\n');
    	}
    	
    	System.out.println(sb);
    }

}