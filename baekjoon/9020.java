import java.util.Scanner;

public class Main {	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[10001];
        
        arr[0] = arr[1] = 0;
        for(int i = 2; i < arr.length; i++) {
        	arr[i] = i;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(arr.length); i++) {
        	if(arr[i] == 0) continue;
        	for(int j = i+i; j < arr.length; j += i) {
        			arr[j] = 0;
        	}
        }
        
        for(int i = 0; i < T; i++) {
        	int n = sc.nextInt();
        	int p1 = n/2;
    		int p2 = n/2;

        	while(true) {
        		if(arr[p1] + arr[p2] == n) break;
        		p1--; p2++;
        	}
        	
        	System.out.println(p1 + " " + p2);
        }
        
    }
}