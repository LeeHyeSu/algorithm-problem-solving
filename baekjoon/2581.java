import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int sum = 0;
        int min = 0;
        	
        for(int i = M; i <= N; i++) {
        	int j = 2;
        	for(; j <= i/2; j++) {
            	if(i % j == 0) break;
           	}
        	if(j > i/2 && i != 1) {
        		sum += i;
        		if(min == 0) min = i;
        	}
        }
        
        if(min == 0) {
        	System.out.println("-1");
        } else {
        	System.out.println(sum + "\n" + min);
        }    
    }
}