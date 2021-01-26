import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	static LinkedList<Integer> que_pri = new LinkedList<Integer>();
	static LinkedList<Integer> que_idx = new LinkedList<Integer>();
	static int N;
	static int M;
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	for(int i = 0; i < T; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0 ; j < N; j++) {
    			que_pri.add(Integer.parseInt(st.nextToken()));
    			que_idx.add(j);
    		}
    		
    		sb.append(printQueue()).append('\n');
    		que_pri.clear();
    		que_idx.clear();
    	}	
    	System.out.println(sb);
    }
    
    static int printQueue() {
    	int cnt = 1;
    	while(!que_pri.isEmpty()) {
	    	int max = que_pri.peek();
	    	int idx = 0;
	    	for(int i = 1; i < que_pri.size(); i++) {
	    		if(max < que_pri.get(i)) {
	    			max = que_pri.get(i);
	    			idx = i;
	    		}
	    	}
	    	
	    	for(int i = 0; i < idx; i++) {
	    		que_pri.add(que_pri.pop());
	    		que_idx.add(que_idx.pop());
	    	}
	    	
	    	if(que_idx.peek() == M) break;
	    	
	    	que_pri.pop();
	    	que_idx.pop();
	    	cnt++;
    	}
    	return cnt;
    }
    
}