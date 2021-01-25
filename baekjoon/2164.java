import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		queue.add(i);
    	}
    	
    	while(queue.size() > 1) {
    		queue.pop();
    		queue.add(queue.pop());
    	}
    	
    	System.out.println(queue.peek());
    }

}