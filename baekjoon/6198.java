import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static class Building {
		int num;
		long height;
		
		Building(int num, long height) {
			this.num = num;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Building> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		long answer = 0;

		for (int i = 1; i <= N; i++) {
			long height = Long.parseLong(br.readLine());
			
			if (stack.isEmpty()) {	// 스택이 비어있다면 빌딩을 push하고 continue
				stack.push(new Building(i, height));
				continue;
			}
			
			Building b = stack.peek();
			
			while (b.height <= height) {	// peek한 빌딩의 높이가 현재 빌딩의 높이보다 같거나 작다면
				answer += i - b.num - 1;	// 현재 빌딩의 번호에서 peek한 빌딩의 번호를 빼주고 -1 해준 값을 answer에 더해준다
				
				stack.pop();				// 스택에서 빌딩을 pop하고
				if (stack.isEmpty()) break;	// 아직 스택에 빌딩이 남아있다면 반복한다
				b = stack.peek();
			}
			
			stack.push(new Building(i, height));	// 현재 빌딩을 push
		}
		
		Building last = stack.pop();	// 마지막 빌딩
		
		/*
		 * 마지막 빌딩을 pop해도 아직 스택에 빌딩이 남아있다면
		 * 남아있는 빌딩의 높이는 내림차순으로 남아있을 것이고, 마지막 빌딩까지 볼 수 있으므로
		 * 마지막 빌딩의 번호에서 peek한 빌딩의 번호를 빼준 값을 answer에 더해준다
		 * 스택이 비어있지 않을 때까지 반복한다
		 */
		while (!stack.isEmpty()) {	
			answer += last.num - stack.peek().num;
			stack.pop();
		}
		
		System.out.println(answer);
	}

}