import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {	
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] cnt = new int[10001];
    	Arrays.fill(cnt, 0);
    	
    	for(int i = 0; i < N; i++) {
    		cnt[Integer.parseInt(br.readLine())]++;
    	}
    	
    	for(int i = 0; i < cnt.length; i++) {
    		while(cnt[i] > 0) {
    			sb.append(i + "\n");
    			cnt[i]--;
    		}
    	}
    	System.out.println(sb);
    }
}