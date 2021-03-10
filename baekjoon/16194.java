import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n + 1];			
		int[] d = new int[n + 1];
		
		String[] s = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(s[i - 1]);
		}
		
		for (int i = 1; i <= n; i++) {
			d[i] = p[i];
			for (int j = 1; j <= i; j++) {
				d[i] = Math.min(d[i], p[j] + d[i - j]);
			}
		}
		
		System.out.println(d[n]);
	}

 }