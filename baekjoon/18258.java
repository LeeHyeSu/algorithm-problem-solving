import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.IOException;

public class Main {		
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int N = Integer.parseInt(br.readLine());
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		command(s);
    	}
    	
    	System.out.println(sb);
    }
    
    public static void command(String s) {
    	if(s.contains("push")) {
			String[] item = s.split(" ");
			queue.add(Integer.parseInt(item[1]));
			return;
		} else if(s.equals("pop")) {
			if(queue.isEmpty()) sb.append(-1);
    		else sb.append(queue.pop());
		} else if(s.equals("size")) {
			sb.append(queue.size());
		} else if(s.equals("empty")) {
			if(queue.isEmpty()) sb.append(1);
    		else sb.append(0);
		} else if(s.equals("front")) {
			if(queue.isEmpty()) sb.append(-1);
    		else sb.append(queue.get(0));
		} else if(s.equals("back")) {
			if(queue.isEmpty()) sb.append(-1);
    		else sb.append(queue.get(queue.size()-1));
		}
    	
    	sb.append('\n');
    	return;
    }
}