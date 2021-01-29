import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[][] map;
	static int[] count = new int[3];

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	divide(0, 0, N);
    	
    	for(int val : count) {
    		System.out.println(val);
    	}
    }
    
    static boolean check(int row, int col, int n) {
    	for(int i = row; i < row+n; i++) {
    		for(int j = col; j < col+n; j++) {
    			if(map[row][col] != map[i][j])
    				return false;
    		}
    	}
    	return true;
    }
    
    static void divide(int row, int col, int n) {
    	if(check(row, col, n)) {
    		count[map[row][col]+1]++;
    	} else {
    		for(int i = 0; i < 3; i++) {
    			for(int j = 0; j < 3; j++) {
    				divide(row + n/3 * i, col + n/3 * j, n/3);
    			}
    		}
    	}
    }

}