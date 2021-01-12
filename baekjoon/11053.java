import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] a = new int[n+1];
   
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		a[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] d = new int[n+1];
    	d[1] = 1;
    	
    	for(int i = 2; i <= n; i++) {
    		d[i] = 1;
    		for(int j = 1; j < i; j++) {
    			if(a[j] < a[i] && d[j] >= d[i]) {
    				d[i] = d[j] + 1;
    			}
    		}
    	}
    	
    	int max = 0;
    	for(int i : d) {
    		max = Math.max(max, i);
    	}
    	
    	System.out.println(max);
    }

}