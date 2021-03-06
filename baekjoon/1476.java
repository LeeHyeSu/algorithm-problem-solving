import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int Y = 1;
		while (E != 1 || S != 1 || M != 1) {
			E--; S--; M--;
			if (E == 0) {
				E = 15;
			}
			if (S == 0) {
				S = 28;
			}
			if (M == 0) {
				M = 19;
			}
			Y++;
		}
		
		System.out.println(Y);
	}
	
}  