import java.io.*;
import java.util.*;

public class Main {
	static int N, r, c;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		divideConquer((int) Math.pow(2, N), 0, 0);
	}
	
	static void divideConquer(int n, int y, int x) {
		if (y == r && x == c) {
			System.out.println(count);
			System.exit(0);
		} 
		
		if (y <= r && r < (y + n) && x <= c && c < (x + n)) {
			n /= 2;
			
			divideConquer(n, y, x);
			divideConquer(n, y, x + n);
			divideConquer(n, y + n, x);
			divideConquer(n, y + n, x + n);
		} else {
			count += n * n;
		}
	}

}
