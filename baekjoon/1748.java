import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String n = br.readLine();
		int len = n.length();
		int ans = 0;
		int cnt = 9;
		
		for (int i = 1; i < len; i++) {
			ans += i * cnt;
			cnt *= 10;
		}
		
		int remainder = Integer.parseInt(n) - (int) Math.pow(10, len - 1);
		ans += (remainder + 1) * len;
		
		System.out.println(ans);
	}

 }