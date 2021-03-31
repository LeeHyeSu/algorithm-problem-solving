import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static String[] words;
	static boolean[] checked = new boolean[26];		// 각 알파벳의 사용 여부 체크
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (K < 5) {		// 어떤 단어도 읽을 수 없는 경우 - 0 출력
			System.out.println(0);
			System.exit(0);
		} 
		if (K == 26){		// 모든 단어를 읽을 수 있는 경우 - N 출력
			System.out.println(N);
			System.exit(0);
		}
		
		// 무조건 배워야 하는 알파벳 
		checked['a' - 'a'] = true;
		checked['n' - 'a'] = true;
		checked['t' - 'a'] = true;
		checked['i' - 'a'] = true;
		checked['c' - 'a'] = true;
		
		words = new String[N];
		for (int i = 0; i < N; i++) {
			// 'anta', 'tica'를 없앤 단어들을 저장
			words[i] = br.readLine().replaceAll("anta|tica", "");
		}
		
		solution(0, 0);
		System.out.println(max);
	}
	
	static void solution(int idx, int count) {
		if (count == K - 5) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				
				for (int j = 0; j < words[i].length(); j++) {
					// 배우지 않은 알파벳이 있는 경우 제외 
					if (!checked[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				
				if (flag) temp++;
			}
			max = Math.max(max, temp);
			return;
		}
		
		// idx 설정(순열 X, 조합 O)
		for (int i = idx; i < 26; i++) {
			if (!checked[i]) {
				checked[i] = true;
				solution(i + 1, count + 1);
				checked[i] = false;
			}
		}
	}
}