import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
	static LinkedList<String> list = new LinkedList<String>();

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int i = 0; i < T; i++) {
    		String p = br.readLine();
    		int n =  Integer.parseInt(br.readLine());
    		String s = br.readLine();
    		String[] x = s.substring(1, s.length()-1).split(",");
    		
    		for(int j = 0; j < x.length; j++) {
    			list.add(x[j]);
    		}
    		
    		int j = 0; int R_cnt = 0;
    		for(; j < p.length(); j++) {
    			if(p.charAt(j) == 'R') {
    				R_cnt++;
    			} else if(p.charAt(j) == 'D') {
    				if(list.isEmpty() || s.equals("[]")) break;
    				if(R_cnt % 2 == 0) list.pollFirst();
    				else list.pollLast();
    			}
    		}
    		if(j == p.length()) {
    			bw.write('[');
    			if(R_cnt % 2 == 0) {
	    			while(!list.isEmpty()) {
	    				bw.write(list.pollFirst());
	    				if(!list.isEmpty()) bw.write(',');
	    			}
    			} else {
    				while(!list.isEmpty()) {
	    				bw.write(list.pollLast());
	    				if(!list.isEmpty()) bw.write(',');
	    			}
    			}
    			bw.write("]\n");
    		} else {
    			bw.write("error\n");
    		}
    		bw.flush();
    		list.clear();
    	}	
    	br.close();
    	bw.close();
    }

}