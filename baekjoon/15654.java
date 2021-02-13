import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] checked;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		checked = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0, new int[M]);
		
		System.out.println(sb);
	}
	
	static void backtracking(int count, int[] pick) {
		if (count == M) {
			for (int i = 0; i < count; i++) {
				sb.append(pick[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!checked[i]) {
				checked[i] = true;
				pick[count] = arr[i];
				backtracking(count + 1, pick);
				checked[i] = false;
			}
		}
	}

}