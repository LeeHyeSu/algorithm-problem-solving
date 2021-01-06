import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][][] arr = new int[21][21][21];
		
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				for (int k = 0; k <= 20; k++) {
					if (i == 0 || j == 0 || k == 0) {
						arr[i][j][k] = 1;
						continue;
					}
					
					if (i < j && j < k) {
						arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
					} else {
						arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
					}
				}
			}
		}
		
		while (true) {
			String str = br.readLine();
			if (str.equals("-1 -1 -1")) break;
			
			String[] sp = str.split(" ");
			int a = Integer.parseInt(sp[0]);
			int b = Integer.parseInt(sp[1]);
			int c = Integer.parseInt(sp[2]);
			
			int value = 0;
			if (a <= 0 || b <= 0 || c <= 0) {
				value = 1;
			} else if (a > 20 || b > 20 || c > 20) {
				value = arr[20][20][20];
			} else {
				value = arr[a][b][c];
			}
			
			sb.append("w("+ a + ", " + b + ", " + c + ") = " + value).append('\n');
		}

		System.out.println(sb);
	} 

}  