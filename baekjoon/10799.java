import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {		// '(' 은 스택에 넣는다.
				stack.push('(');
				continue;
			} 
			
            // 현재 문자가 ')' 일 때
			if (str.charAt(i - 1) == '(') {	// 앞의 문자가 '(' 이면 레이저
				stack.pop();				// 레이저였던 '(' 제거
				sum += stack.size();		// 현재 스택의 사이즈만큼 더해준다.
			} else {				// 그냥 막대기의 끝이라면
				stack.pop();		// 막대기의 시작이었던 '(' 제거
				sum += 1;			// 막대기의 마지막 조각인 1을 더해준다.
			}
		}
		
		System.out.println(sum);
	}

}