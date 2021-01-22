import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	int twoCount = calc(n, 2) - calc(n - k, 2)- calc(k, 2);
    	int fiveCount = calc(n, 5) - calc(n - k, 5) - calc(k, 5);
    	
    	System.out.println(Math.min(twoCount, fiveCount));
    }
    
    public static int calc(int n, int i) {
    	int count = 0;
    	
    	while (n >= i) {
    		count += n / i; 	// n까지 i의 배수의 개수
    		n /= i;
    	}
    	
    	return count;
    }
    
}