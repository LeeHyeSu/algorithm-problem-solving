import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	LinkedList<Integer> queue = new LinkedList<Integer>();

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	for(int i = 1; i <= N; i++) {
    		queue.add(i);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append('<');
    	while(!queue.isEmpty()) {
    		for(int i = 0; i < K-1; i++) {
    			queue.add(queue.pop());
    		}
    		sb.append(queue.pop());
    		if(queue.size() != 0) sb.append(", ");
    	}
    	sb.append('>');
    	
    	System.out.println(sb);
    }

}