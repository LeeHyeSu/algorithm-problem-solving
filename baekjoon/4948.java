import java.util.Scanner;

public class Main {	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
        	int n = sc.nextInt();
        	if(n == 0) break;
        	
        	int count = 0;
        	for(int i = n+1; i <= n*2; i++) {
        		int j = 2;
        		for(; j <= (int)Math.sqrt(n*2); j++)
        			if(i % j == 0) break;
        		if(j > (int)Math.sqrt(n*2)) count++;
        	}
        	
        	System.out.println(count);
        }
        
    }
}