import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0, 0, "");
		
		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append(s).append('\n'); 
		}
		
		System.out.println(sb);
	}

	private static void backtracking(int count, int at, String str) {
		if (count == m) {
			set.add(str.trim());
			return;
		}
		
		for (int i = at; i < n; i++) {
			backtracking(count + 1, i + 1, str + arr[i] + " ");
		}
	}

}