import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int count = Integer.parseInt(br.readLine());
    	int[] divisors = new int[count];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < count; i++) {
    		divisors[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(divisors);
    	
    	System.out.println(divisors[0] * divisors[count-1]);
    }

}