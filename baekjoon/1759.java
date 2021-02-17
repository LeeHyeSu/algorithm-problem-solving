import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0, "");
		
		System.out.println(sb);
	}
	
	static void dfs(int at, int count, String s) {
		if (count == L) {
			int vcnt = 0;	// 모음 개수
			int ccnt = 0;	// 자음 개수
			for (char ch : s.toCharArray()) {
				if (ch == 'a' || ch == 'e' || ch == 'i'
						|| ch == 'o' || ch == 'u') vcnt++;
				else ccnt++;
			}
			
			if (vcnt >= 1 && ccnt >= 2) {
				sb.append(s).append('\n');
			}
			return;
		}
		
		for (int i = at; i < C; i++) {
			dfs(i + 1, count + 1, s + arr[i]);
		}
	}

 }