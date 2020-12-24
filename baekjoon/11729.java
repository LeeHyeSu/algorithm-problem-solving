import java.util.Scanner;
import java.util.Arrays;

public class Main {	
	static int n, cnt=0;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    
    static void hanoi(int n, int from, int by, int to) {
    	cnt++;
    	if(n == 1) {	// 원판이 1 개일 때
    		sb.append(from + " " + to + "\n");
    		return;
    	} else {	// 원판이 1개가 아닐 때
    		hanoi(n-1, from, to, by);	// n-1개를  1->3->2순으로 원판을 전달
    		sb.append(from + " " + to + "\n");
    		hanoi(n-1, by, from, to);	// n-1개를 2->1->3순으로 원판을 전달 
    	}   	
    }
}