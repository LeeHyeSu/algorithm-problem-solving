import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (nextPermutation(arr)) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
	
	static boolean nextPermutation(int[] arr) {
		
		// 뒤에서부터 탐색하면서 a-1 보다 a가 더 큰 경우를 찾음 
		int a = arr.length - 1;
		while (a > 0 && arr[a-1] >= arr[a]) a--;
		if (a <= 0) return false;
		
		// 다시 뒤에서부터 탐색하면서 a-1보다 b가 더 큰 경우를 찾음
		int b = arr.length - 1;
		while (arr[a-1] >= arr[b]) b--;
		
		// a-1 과  b의 자리를 바꿈
		int tmp = arr[a-1];
		arr[a-1] = arr[b];
		arr[b] = tmp;
		
		int start = a;
		int end = arr.length - 1;
		
		// a에서부터 끝까지 오름차순 정렬
		while (start < end) {
			tmp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = tmp;
		}
		return true;
	}
	
}