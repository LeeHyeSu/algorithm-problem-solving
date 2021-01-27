import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {	
	static LinkedList<Integer> d = new LinkedList<Integer>();
	static int N;
	static int M;
	static int min = 0;
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	for(int i = 1; i <= N; i++) {
    		d.add(i);
    	}
    	st = new StringTokenizer(br.readLine());
    	while(st.hasMoreTokens()) {
    		dequeMin(Integer.parseInt(st.nextToken()));
    	}
    	System.out.println(min);
    }

    static void dequeMin(int pos) {
    	int i = 0;
    	for(; i < d.size(); i++) {
    		if(pos == d.get(i)) break;
    	}
    	
    	if(i <= d.size() / 2) {
    		int cnt = 0;
    		while(pos != d.peekFirst()) {
    			d.addLast(d.pollFirst());
    			cnt++;
    		}
    		d.pollFirst();
    		min += cnt;
    	} else {
    		int cnt = 0;
    		while(pos != d.peekFirst()) {
    			d.addFirst(d.pollLast());
    			cnt++;
    		}
    		d.pollFirst();
    		min += cnt;
    	}
    }
    
}