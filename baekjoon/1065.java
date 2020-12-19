import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result += func(i);
        }
        System.out.println(result);
    }
    
    public static int func(int n) {
        if(n < 10) {
            return 1;
        }

        int length = (int)(Math.log10(n)+1);
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] += n % 10;
            n = n / 10;
        }

        int diff = arr[0] - arr[1];
        for(int i = 1; i < arr.length-1; i++) {
            if(diff != (arr[i] - arr[i+1])) {
                return 0;
            }
        }
        return 1;
    }
}