import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] p = new long[n + 1][2];
		p[1][1] = 1;
		
		/*
		 * 0으로 끝나는 경우는 앞의 경우의 수가 0 과 1 모두 가능
		 * 1로 끝나는 경우에는 앞의 경우의 수가 0 으로 끝나야 함
		 */
		for (int i = 2; i <= n; i++) {
			p[i][0] = p[i - 1][0] + p[i - 1][1];
			p[i][1] = p[i - 1][0];
		}
		
		long ans = p[n][0] + p[n][1];
		System.out.println(ans);
	}

 }