import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {		
	private static Stack<Integer> stack = new Stack<Integer>();
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];		
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());	
    	}
    	
    	int idx = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= N; i++) {
    		stack.push(i);
    		sb.append('+').append('\n');
    		
    		while(!stack.isEmpty() && stack.peek() == arr[idx]) {
    			stack.pop();
    			sb.append('-').append('\n');
    			idx++;
    		}
    	}
    	
    	if(!stack.isEmpty()) System.out.println("NO");
    	else System.out.println(sb);
    }
    
}