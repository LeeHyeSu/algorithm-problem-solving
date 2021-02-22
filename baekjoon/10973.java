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
		
		if (prevPermutation(arr)) {
			for (int value : arr) {
				System.out.print(value + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
	
	static boolean prevPermutation(int[] arr) {
		
		// 1. 뒤에서 arr[a-1] > arr[a]를 만족하는 첫 번째 수 찾기
		int a = arr.length - 1;
		while (a > 0 && arr[a-1] <= arr[a]) a--;
		if (a == 0) return false;	// 첫 번째 순열인 경우 false 리턴
		
		// 2. 뒤에서 arr[a-1] > arr[b]를 만족하는 첫 번째 수 찾기
		int b = arr.length - 1;
		while (arr[a-1] <= arr[b]) b--;
		
		// 3. arr[a-1]과 arr[b] swap
		swap(arr, a-1, b);

		// 4. a부터 arr.length-1 까지 순열 뒤집기
		int start = a;
		int end = arr.length - 1;
		while (start < end) {
			swap(arr, start, end);
			start++; end--;
		}
		return true;
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}