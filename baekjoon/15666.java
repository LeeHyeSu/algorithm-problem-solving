import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, pick;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		pick = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0, 0);

		System.out.println(sb);
	}

	private static void backtracking(int count, int at) {
		if (count == m) {
			for (int value : pick) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int before = 0;
		
		for (int i = at; i < n; i++) {
			if (before == arr[i]) continue;
			
			pick[count] = arr[i];
			backtracking(count + 1, i);
			
			before = arr[i];
		}
	}

}  