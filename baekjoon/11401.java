import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// Fermat’s little Theorem(페르마의 소정리)
public class Main {
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	long p =  1000000007;
    	
    	long[] factorial = new long[n+1];
    	factorial[0] = 1;
    	factorial[1] = 1;
    	
    	// factorial 구하기
    	for(int i = 2; i <= n; i++) {
    		factorial[i] = (factorial[i-1] * i) % p;
    	}
    	long denominator = (factorial[k] * factorial[n-k]) % p;
    	
    	// fermatNum(denominator의 K-2 제곱 구하기)
    	long index = p-2;
    	long fermatNum = 1;
    	while(index > 0) {
    		if(index % 2 == 1) {
    			fermatNum *= denominator;
    			fermatNum %= p;
    		}
    		denominator = (denominator * denominator) % p;
    		index /= 2;
    	}
    	long result = ((factorial[n] % p) * (fermatNum % p)) % p;
    	System.out.println(result);
    }

}