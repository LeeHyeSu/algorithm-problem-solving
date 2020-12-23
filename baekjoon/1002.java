import java.util.Scanner;

public class Main {	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
        	int x1 = sc.nextInt();
        	int y1 = sc.nextInt();
        	int r1 = sc.nextInt();
        	int x2 = sc.nextInt();
        	int y2 = sc.nextInt();
        	int r2 = sc.nextInt();
        	
        	int dist = (int)Math.pow(x1-x2, 2) + (int)Math.pow(y1-y2, 2);
        	int sum = (int)Math.pow(r1+r2, 2);
        	int diff = (int)Math.pow(r1-r2, 2);
        	int cnt = 0;

        	if(x1 == x2 && y1 == y2 && r1 == r2) cnt = -1;
        	else if(dist > sum) cnt = 0;
        	else if(dist == sum) cnt = 1;
        	else if(dist < diff) cnt = 0;
        	else if(dist == diff) cnt = 1;
        	else cnt = 2;     	
        	
        	System.out.println(cnt);
        }
    }
}