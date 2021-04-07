import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		int idx = 1;	// 테스트 케이스 번호
		while (true) {
			String str = br.readLine();
			if (str.contains("-")) break;	// '-' 문자가 있을 경우 반복문 종료
			
			int count = 0;	// 괄호 변경 횟수
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '{') {	// 여는 괄호라면 스택에 넣는다
					stack.push(ch);
					continue;
				}
				
				if (stack.isEmpty()) {	// 닫는 괄호일 때 스택이 비어있다면
					count++;			// 변경 횟수를 1 늘리고
					stack.push('{');	// 여는 괄호로 변경하여 스택에 넣는다
				} else {				// 스택이 비어있지 않다면 
					stack.pop();		// '{' 괄호를 스택에서 꺼낸다
				}
			}
			
			/*
			 * 문자열 순회가 끝나도 스택이 비어있지 않다면 
			 * 변경 횟수에 (스택의 크기 / 2) 만큼 더해주고
			 * 스택을 비운다
			 */
			if (!stack.isEmpty()) {
				count += stack.size() / 2;
				stack.clear();
			}
			
			sb.append(idx++).append(". ")
				.append(count).append('\n');
		}
		
		System.out.println(sb);
	}

}