import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
		
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	public static void comb(int idx, int count) {
		if (count == m) {
			for (int value : pick) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = idx; i < n; i++) {
			pick[count] = arr[i];
			comb(i + 1, count + 1);
		}
	}

}  