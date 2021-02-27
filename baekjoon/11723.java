import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 비트마스크(BitMask)
 * : 이진수를 사용하는 컴퓨터의 연산 방식을 이용하여, 정수의 이진수 표현을 자료 구조로 쓰는 기법
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		
		while (M-- > 0) {
			String[] input = br.readLine().split(" ");
			String cmd = input[0];
			
			if (cmd.equals("all")) {
				bitset = (1 << 21) - 1;
				continue;
			} 
			if (cmd.equals("empty")) {
				bitset = 0;
				continue;
			}
			
			int num = Integer.parseInt(input[1]);
			switch (cmd) {
				case "add":
					bitset |= (1 << num);
					break;
				case "remove":
					bitset &= ~(1 << num);
					break;
				case "check":
					int check = ((bitset & (1 << num)) == 0) ? 0 : 1;
					sb.append(check).append('\n');
					break;
				case "toggle":
					bitset ^= (1 << num);
					break;
			}
		}
		
		System.out.println(sb);
	}
	
 }