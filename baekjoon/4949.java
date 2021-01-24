import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {		
	private static Stack<Character> stack = new Stack<Character>();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		String str = br.readLine();
    		
    		if(str.equals(".")) break;
    		
    		if(Balance(str)) sb.append("yes \n");
    		else sb.append("no \n");
    		
    		stack.clear();
    	}
    	
    	System.out.println(sb);
    }
    
    public static boolean Balance(String s) {
    	for(char ch : s.toCharArray()) {
    		if(ch == '(' || ch == '[') {
    			stack.push(ch);
    		} else if(ch == ')') {
    			if(stack.isEmpty() || stack.pop() != '(') return false;
    		} else if(ch == ']') {
    			if(stack.isEmpty() || stack.pop() != '[') return false;
    		}
    	}
    	
    	if(stack.isEmpty()) return true;
    	else return false;
    }
    
}