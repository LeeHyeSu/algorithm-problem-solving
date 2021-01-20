import java.io.*;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] r = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < n; i++) {
    		r[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 1; i < n; i++) {
    		int gcdVal = gcd(r[0], r[i]);
    		
    		String s1 = String.valueOf(r[0] / gcdVal);
    		String s2 = String.valueOf(r[i] / gcdVal);
    		
    		sb.append(s1 + "/" + s2 + "\n");
    	}
    	
    	System.out.println(sb);
    	
    }
    
    public static int gcd(int a, int b) {
    	if (a % b == 0) return b;
    	else return gcd(b, a % b);
    }

}