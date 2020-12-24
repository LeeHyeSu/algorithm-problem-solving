import java.util.Scanner;
import java.util.Arrays;

public class Main {	
	static char[][] arr;
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];
        
        for(int i = 0; i < N; i++) {
        	Arrays.fill(arr[i], ' ');
        }
        
        star(0, 0, N);
        
        for(int i = 0; i < N; i++) {
        	System.out.println(arr[i]);
        }
    }
    
    static void star(int x, int y, int n) {
    	if(n == 1) {
    		arr[x][y] = '*';
    		return;
    	}

    	int size = n / 3;
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(i == 1 && j == 1) continue;
    			star(x+size*i, y+size*j, size);
    		}
    	}
    	
    }
}