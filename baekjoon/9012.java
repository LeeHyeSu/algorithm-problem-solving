import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {		
	private static Stack<Character> stack = new Stack<Character>();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < T; i++) {
    		String s = br.readLine();
    		
    		if(VPS(s)) sb.append("YES \n");
    		else sb.append("NO \n");
    		
    		stack.clear();
    	}
    	
    	System.out.println(sb);
    }
    
    public static boolean VPS(String s) {
    	for(int i = 0; i < s.length(); i++) {
    		// '(' 이면  push ')'이면 pop, 스택이 비어있는 상태에서 pop하려 하면 false 리턴
    		if(s.charAt(i) == '(') {
    			stack.push(s.charAt(i));
    		} else {
    			if(stack.isEmpty()) return false;
    			else stack.pop();
    		}
    	}
    	
    	// 연산 후 스택이 비어있으면 true, 아니면 false
    	if(stack.isEmpty()) return true;
    	else return false;
    }
    
}