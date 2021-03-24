import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static char[] sign;
	static int[] pick;
	static boolean[] checked = new boolean[10];
	static String max = "0";
	static String min = "9876543210";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		sign = new char[k];
		pick = new int[k + 1];
		
		String s = br.readLine();
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != ' ') {
				sign[idx++] = ch;
			}
		}
		
		solution(0);
		
		System.out.println(max + "\n" + min);
	}
	
	static void solution(int count) {
		if (count == k + 1) {
			if (condition()) {
				String s = "";
				for (int value : pick) {
					s += value;
				}
				
				if (Long.parseLong(max) < Long.parseLong(s)) {
					max = s;
				}
				if (Long.parseLong(min) > Long.parseLong(s)) {
					min = s;
				}
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (!checked[i]) {
				checked[i] = true;
				pick[count] = i;
				solution(count + 1);
				checked[i] = false;
			}
		}
	}
	
	static boolean condition() {
		for (int i = 0; i < k; i++) {
			if (sign[i] == '<') {
				if (pick[i] > pick[i + 1]) return false;
			} else {
				if (pick[i] < pick[i + 1]) return false;
			}
		}
		return true;
	}

}
