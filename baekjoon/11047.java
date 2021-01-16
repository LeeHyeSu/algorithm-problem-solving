import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] A = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int cnt = 0;
    	for(int i = N-1; i >= 0; i--) {
    		if(K >= A[i]) {
    			cnt += K / A[i];	// 몫 = 동전개수
    			K %= A[i];			// 나머지 값 = 남은 값
    			if(K == 0) {
    				break;
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    }
    
}