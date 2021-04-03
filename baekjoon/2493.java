import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1. 스택이 비어있다면 0을 출력하고, 현재 탑을 스택에 push한다.
 * 2. 스택이 비어있지 않다면, 
 * 2-1. 스택에서 peek한 탑의 높이가 현재 탑의 높이보다 높다면, 
 * 		peek한 탑의 번호를 출력하고, 현재 탑을 스택에 push한다.
 * 2-2. 스택에서 peek한 탑의 높이가 현재 탑의 높이보다 낮다면,
 * 		peek한 탑을 pop하고 2번으로 다시 돌아간다.
 */
public class Main {
	
	static class Top {
		int num;		// 탑의 번호
		int height;		// 탑의 높이
		
		Top(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			while (true) {
				if (stack.isEmpty()) { // 스택이 비어있다면, 0을 출력하고 탑을 push
					sb.append("0 ");
					stack.push(new Top(i, height));
					break;
				}
				
				Top top = stack.peek();
				
				if (top.height > height) {	// peek한 탑의 높이가 현재 탑의 높이보다 높다면,
					sb.append(top.num).append(' ');	// peek한 탑의 번호를 출력하고,
					stack.push(new Top(i, height));	// 현재 탑을 스택에 push한다.
					break;
				} else {			// peek한 탑의 높이가 현재 탑의 높이보다 낮다면,
					stack.pop();	// 스택에서 pop하고 다시 반복문을 돌린다.
				}
			}
		}
		
		System.out.println(sb);	
	}

 }