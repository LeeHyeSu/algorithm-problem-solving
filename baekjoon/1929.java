import java.util.Scanner;

// 1929 소수 구하기 : M이상 N이하의 소수를 모두 출력하는 프로그램
// 에라토스테네스의 체
public class Main {	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        arr[0] = arr[1] = 0;
        
        for(int i = 2; i < arr.length; i++) {
        	arr[i] = i;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(N); i++) {
        	if(arr[i] == 0) continue;
        	for(int j = i+i; j <= N; j += i) {
        		arr[j] = 0;
        	}
        }
        
        for(int i = M; i < arr.length; i++) {
        	if(arr[i] != 0) System.out.println(arr[i]);
        }
        
    }
}
