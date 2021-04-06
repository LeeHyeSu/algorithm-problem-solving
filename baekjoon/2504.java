import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == '(' || ch =='[') {	// 여는 괄호이면 스택에 넣음
				stack.push(String.valueOf(ch));
				continue;
			} 
			
			if(stack.isEmpty()){		// 스택이 비어있는 상태에 닫는 괄호가 들어오면 올바르지 못한 괄호열
                System.out.println(0);
                return;
            }
			
			if (ch == ')') {	// 닫는 괄호가 ')'일 때
				if (stack.peek().equals("(")) {	// 중첩된 괄호가 아니라면 스택에 '2'를 넣는다
					stack.pop();
					stack.push("2");
				}
				else {	// 중첩된 괄호가 있다면
					int sum = 0;
					while (!stack.isEmpty()) {	
						String temp = stack.pop();
						if (temp.equals("[")) {	// 여는 괄호가 맞지 않으면 올바르지 못한 괄호열
							System.out.println(0);
							return;
						}
							
						if (temp.equals("(")) {	// 여는 괄호가 나오면 숫자의 합에 2를 곱해준다
							stack.push(String.valueOf(sum * 2));
							break;
						}
						
						sum += Integer.parseInt(temp); // 여는 괄호가 나올 때까지 스택 안에 있는 숫자를 더한다
					}
				}
			} 
			else if (ch == ']') {	// 닫는 괄호가 ']'일 때
				if (stack.peek().equals("[")) {	// 중첩된 괄호가 아니라면 스택에 '3'을 넣는다
					stack.pop();
					stack.push("3");
				}
				else {
					int sum = 0;
					while (!stack.isEmpty()) {	
						String temp = stack.pop();
						if (temp.equals("(")) {	// 여는 괄호가 맞지 않으면 올바르지 못한 괄호열
							System.out.println(0);
							return;
						}
						
						if (temp.equals("[")) {	// 여는 괄호가 나오면 숫자의 합에 3을 곱해준다
							stack.push(String.valueOf(sum * 3));
							break;
						}
						
						sum += Integer.parseInt(temp); // 여는 괄호가 나올때까지 스택 안에 있는 숫자를 더한다
					}
				}
			}
		}
		
		int answer = 0;
		
		while (!stack.isEmpty()) {	
			String temp = stack.pop();
			if (temp.equals("(") || temp.equals("[")) {	// 괄호가 남아있다면 올바르지 못한 괄호열
				System.out.println(0);
				return;
			}
			answer += Integer.parseInt(temp); 	// 스택에 남아 있는 값들을 모두 더해준다
		}
		
		System.out.println(answer);
	}

}