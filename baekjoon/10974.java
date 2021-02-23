import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
			sb.append(arr[i]).append(' ');
		}
		sb.append('\n');
		
		while (nextPermutation(arr)) {
			for (int v : arr) {
				sb.append(v).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean nextPermutation(int[] arr) {
		int a = arr.length - 1;
		while (a > 0 && arr[a-1] >= arr[a]) a--;
		if (a == 0) return false;
		
		int b = arr.length - 1;
		while (arr[a-1] >= arr[b]) b--;
		
		swap(arr, a-1, b);
		
		b = arr.length - 1;
		while (a < b) {
			swap(arr, a++, b--);
		}
		
		return true;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}  