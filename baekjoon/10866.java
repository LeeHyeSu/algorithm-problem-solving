import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.IOException;

public class Main {		
	static Deque<Integer> d = new ArrayDeque<Integer>();
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i = 0; i < N; i++) {
    		deque(br.readLine());
    	}
    	System.out.println(sb);
    }
    
    static void deque(String s) {
    	int result = 0;
    	
    	if(s.contains("push")) {
	    	if(s.contains("front")) {
	    		d.addFirst(Integer.parseInt(s.split(" ")[1]));
	    	} else if(s.contains("back")) {
	    		d.addLast(Integer.parseInt(s.split(" ")[1]));
	    	}
	    	return;
    	} 

    	if(s.equals("pop_front")) {
    		if(d.isEmpty()) result = -1;
    		else result = d.pollFirst();
    	} else if(s.equals("pop_back")) {
    		if(d.isEmpty()) result = -1;
    		else result = d.pollLast();
    	} else if(s.equals("size")) {
    		result = d.size();
    	} else if(s.equals("empty")) {
    		if(d.isEmpty()) result = 1;
    		else result = 0;
    	} else if(s.equals("front")) {
    		if(d.isEmpty()) result = -1;
    		else result = d.peekFirst();
    	} else if(s.equals("back")) {
    		if(d.isEmpty()) result = -1;
    		else result = d.peekLast();
    	}
    	
    	sb.append(result).append('\n');
    	return;
    }
    
}