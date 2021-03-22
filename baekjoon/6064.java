import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 풀이 아이디어 - x를 먼저 맞추고, y를 따라가게 한다.
 * 				 y는 M만큼 증가시키고 N으로 나머지 연산을 해주는 것.
 * 예외인 경우를 위해 최소공배수를 활용한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int count = x;
			int tempY = x;
			
			for (int i = 0; i < n; i++) {
				int ty = tempY % n == 0 ? n : tempY % n;
				if (ty == y) break;
				
				tempY = ty + m;
				count += m;
			}
			
			if (count > lcm(m, n)) sb.append(-1);
			else sb.append(count);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	static int gcd(int a, int b) {
		if (a % b == 0) return b;
		else return gcd(b, a % b);
	}
}
