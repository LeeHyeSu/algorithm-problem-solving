import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] a = new int[n+1];
    	for(int i = 1; i <= n; i++) {
    		a[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int[] f = new int[n+1];
    	f[1] = a[1];
    	if(n >= 2) f[2] = a[1] + a[2];
    	for(int i = 3; i <= n; i++) {
    		f[i] = Math.max(Math.max(f[i-3]+a[i-1]+a[i], f[i-2]+a[i]), f[i-1]);
    	}
    	
    	System.out.println(f[n]);
    }

}