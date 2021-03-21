import java.util.Scanner;

public class Main {
	static boolean[] button = new boolean[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		for (int i = 0; i < m; i++) {
			button[sc.nextInt()] = true;
		}
		
		// 초기 채널은 100번이므로 +와 -번으로만 이동 가능한 것이 최대 이동 횟수.
		int ans = Math.abs(n - 100);
		
		for (int i = 0; i < 1000000; i++) {
			// 채널 i번을 눌러서 이동 가능한지 확인
			int len = solution(i);
			
			if (len != 0) {
				// cnt는 근접한 채널에서 + 또는 -를 누르는 횟수
				int cnt = Math.abs(i - n);
				if (ans > len + cnt) {
					ans = len + cnt;
				}
			}
		}
		
		System.out.println(ans);
	}

	static int solution(int n) {
		// 채널 n번을 눌러서 이동 가능하다면 채널 번호를 누르는 횟수 리턴, 가능하지 않다면 0 리턴
		int len = 0;
		
		if (n == 0) return button[0] ? 0 : 1;
		
		// 채널 번호를 반대로 눌러도 상관 X
		while (n > 0) {
			// 고장난 버튼이라면 리턴
			if (button[n % 10]) {
				return 0;
			}
			len++;
			n /= 10;
		}
		
		return len;
	}
 }