import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] arr;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		// 합이 0일 경우 공집합도 포함되므로 수를 하나 빼준다
		if (S == 0) count--;
		System.out.println(count);
	}
	
	static void dfs(int length, int sum) {
		if (length == N) {
			if (sum == S) count++;
			return;
		}
		
		// 부분수열: 지금 위치의 원소를 선택하거나, 선택하지 않거나
		dfs(length + 1, sum + arr[length]);
		dfs(length + 1, sum);
	}

 }