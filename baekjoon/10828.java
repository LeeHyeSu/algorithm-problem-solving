import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {		
	static Stack<Integer> stack = new Stack<Integer>();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		if(s.contains("push")) {
    			String[] item = s.split(" ");
    			stack.push(Integer.parseInt(item[1]));
    		} else {
    			sb.append(command(s)).append('\n');
    		}
    	}
    	
    	System.out.println(sb);
    }
    
    static int command(String s) {
    	switch(s) {
            case "pop":
                return stack.size() == 0 ? -1 : stack.pop();
            case "size":
                return stack.size();
            case "empty":
                return stack.empty() ? 1 : 0;
            case "top":
                return stack.size() == 0 ? -1 : stack.peek();
    	}
    	
    	return 0;
    }
    
}