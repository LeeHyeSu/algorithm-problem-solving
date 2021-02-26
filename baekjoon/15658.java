import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] a;
	static int[] ops;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		ops = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, a[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int idx, int sum) {
		if (idx == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (ops[i] == 0) continue;
			
			ops[i]--;
			switch (i) {
				case 0:
					dfs(idx + 1, sum + a[idx]);
					break;
				case 1:
					dfs(idx + 1, sum - a[idx]);
					break;
				case 2:
					dfs(idx + 1, sum * a[idx]);
					break;
				case 3:
					dfs(idx + 1, sum / a[idx]);
					break;
			}
			ops[i]++;
		}
	}

 }