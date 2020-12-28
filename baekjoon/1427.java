import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {	
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	String N = br.readLine();
    	String[] arr = N.split("");
    	
    	Arrays.sort(arr, Collections.reverseOrder());
    	
    	for(String s : arr) {
    		sb.append(s);
    	}
    	System.out.println(sb);
    }
}