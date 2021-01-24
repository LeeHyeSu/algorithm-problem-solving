import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];				// 입력 배열
		int[] answer = new int[n];			// 정답 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();	// 스택에 인덱스를 저장함
		stack.push(0);		// 첫 번째 인덱스 저장
		
		for (int i = 1; i < n; i++) {
			// 스택의 top에 있는 인덱스의 값이 i번째 인덱스의 값보다 작으면 pop하여 정답 배열에 저장
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		// 스택에 남아있는 인덱스들은 오큰수가 없으므로 -1 저장
		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		
		for (int value : answer) {
			bw.write(value + " ");
		}
		
		bw.write("\n");
		bw.flush();
	}

}  