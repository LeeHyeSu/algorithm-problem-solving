import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static long A;
	static long B;
	static long C;
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	A = Long.parseLong(st.nextToken());
    	B = Long.parseLong(st.nextToken());
    	C = Long.parseLong(st.nextToken());
    	
    	System.out.println(pow(B));
    }

    public static long pow(long B) {
    	if(B == 1) {
    		return A % C;
    	} 

    	long pow = pow(B/2);
    	
    	if(B % 2 == 0){
    		return pow * pow % C;
    	} else {
    		return (A * (pow * pow % C)) % C;
    	}
    }

}