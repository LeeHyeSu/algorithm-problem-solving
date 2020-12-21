import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	
        	int dist = y - x;
        	int max = (int)Math.sqrt(dist);
        	int count = 0;
        	
        	if(max == Math.sqrt(dist)) {
        		count = max * 2 - 1;
        	} else if(dist <= max * max + max) {
        		count = max * 2;
        	} else {
        		count = max * 2 + 1;
        	}
        	
        	System.out.println(count);
        }
    }
    
}