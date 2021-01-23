import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int K = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(int i = 0; i < K; i++) {
    		int n = Integer.parseInt(br.readLine());
    		if(n == 0) stack.pop();
    		else stack.push(n);
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < stack.size(); i++) {
    		sum += stack.get(i);
    	}
    	System.out.println(sum);
    }
    
}