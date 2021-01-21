import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	while(T > 0) {
    		HashMap<String, Integer> map = new HashMap<>();
    		int n = Integer.parseInt(br.readLine());
    		 
    		for (int i = 0; i < n; i++) {
    			String type = br.readLine().split(" ")[1];
    			map.put(type, map.getOrDefault(type, 0) + 1);
    		}
    		
    		int cases = 1;
    		for (int value : map.values()) {
                // 의상을 입지 않을 경우를 고려하여 + 1을 해준다.
    			cases *= value + 1;
    		}
            
            // 의상을 하나도 입지 않을 경우는 제외한다. 
    		sb.append(cases - 1).append('\n');
    		
    		T--;
    	}
    	
    	System.out.println(sb);
    }
    
}