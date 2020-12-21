import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = N;
        
        for(int i = 0; i < N; i++) { 
        	int p = sc.nextInt();
        	
        	if(p == 1) cnt--;
        	for(int j = 2; j <= p/2; j++) {
        		if(p % j == 0) {
        			cnt--;
        			break;
        		}
        	}
        }
        
        System.out.println(cnt);
    }
    
}