import java.util.Scanner;

public class Main {	

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int i = 666;
    	int cnt = 1;
    	
    	while(N != cnt) {
    		i++;
    		if(isEnd(i)) cnt++;
    	}
    
    	System.out.println(i);
    }
    
    static boolean isEnd(int i) {
    	int six_cnt = 0;
    	while(i > 0) {
    		if(i % 10 == 6) {
    			six_cnt++;
    		} else {
    			if(six_cnt < 3) six_cnt = 0;
    		}
    		i = i / 10;
    	}
    	if(six_cnt >= 3) return true;
    	else return false;
    }
    
}