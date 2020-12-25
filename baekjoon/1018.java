import java.util.Scanner;

public class Main {	
	static final char[][] white = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	static final char[][] black = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	static char[][] arr;
	
	static int check(int a, int b) {
		int white_cnt = 0;
		int black_cnt = 0;
		for(int i = a; i < a+8; i++) {
			for(int j = b; j < b+8; j++) {
				if(white[i-a][j-b] != arr[i][j]) {
					white_cnt++;
				}
				if(black[i-a][j-b] != arr[i][j]) {
					black_cnt++;
				}
			}
		}
		return Math.min(white_cnt, black_cnt);
	}
	
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
   
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	arr = new char[N][M];
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.next().toCharArray();
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i <= N-8; i++) {
    		for(int j = 0; j <= M-8; j++) {
    			min = Math.min(min, check(i,j));
    		}
    	}
    	
    	System.out.println(min);
    }
}