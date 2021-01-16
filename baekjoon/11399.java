import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] P = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	for(int i = 0; i < N; i++) {
    		P[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 각 사람이 돈을 인출하는데 필요한 시간 순으로 정렬
    	Arrays.sort(P);	
    	
    	int sum = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < i+1; j++) {
    			sum += P[j];
    		}
    	}
    	
    	System.out.println(sum);
    }
    
}