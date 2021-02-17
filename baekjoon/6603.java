import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(s);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(0, 0, "");

			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

	static void lotto(int at, int count, String s) throws IOException {
		if (count == 6) {
			bw.write(s.trim() + "\n");
			return;
		}
		
		for (int i = at; i < k; i++) {
			lotto(i + 1, count + 1, s + arr[i] + " ");
		}
	}
 }  