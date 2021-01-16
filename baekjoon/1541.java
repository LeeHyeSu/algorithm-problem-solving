import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] m = br.readLine().split("-");
    	
    	int sum = 0;
    	for(int i = 0; i < m.length; i++) {
    		if(m[i].contains("+")) {
    			String[] p = m[i].split("\\+");	// + 넣으면 에러
    			for(int j = 0; j < p.length; j++) {
    				if(i == 0) sum += Integer.parseInt(p[j]);
    				else sum -= Integer.parseInt(p[j]);
    			}
    		} else {
    			if(i == 0) sum += Integer.parseInt(m[i]);
    			else sum -= Integer.parseInt(m[i]);
    		}
    	}
    	
    	System.out.println(sum);
    }
    
}