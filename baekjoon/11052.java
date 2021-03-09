import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 카드 i개를 구매하는 방법은 ?
	 * - 카드 1개가 들어있는 카드팩을 구매하고 카드 i - 1 개를 구입한다.
	 * - 카드 2개가 들어있는 카드팩을 구매하고 카드 i - 2 개를 구입한다.
	 * - 카드 3개가 들어있는 카드팩을 구매하고 카드 i - 3 개를 구입한다.
	 * ...
	 * D[i] = P[j] + D[i - j]
	 * 가장 큰 비용으로 n개를 구매하는 방법까지 도달하기 전에 
	 * n보다 작은 카드들을 가장 큰 비용으로 구매하는 방법들을 기억해놓고,
	 * 이전에 구했던 값들을 이용해 n개를 가장 큰 비용으로 구매하는 방법을 구하는 방식
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n + 1];		// n개의 카드팩을 사기 위한 비용
		int[] d = new int[n + 1];		// n개의 카드팩을 사기 위해 지불해야하는 최대 값
		
		String[] s = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(s[i - 1]);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], p[j] + d[i - j]);
			}
		}
		
		System.out.println(d[n]);	
	}

 }