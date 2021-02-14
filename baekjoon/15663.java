import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] checked;
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		checked = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backtracking(0, "");
		
		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void backtracking(int count, String s) {

		if (count == m) {
			set.add(s.trim());
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!checked[i]) {	
				checked[i] = true;
				backtracking(count + 1, s + arr[i] + " ");
				checked[i] = false;
			}
		}
		
	}

}  