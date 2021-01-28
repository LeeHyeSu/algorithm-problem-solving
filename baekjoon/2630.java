import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[][] paper;
	static int blue_paper = 0;
	static int white_paper = 0;

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	paper = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0; j < N; j++) {
    			paper[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	cutPaper(0, 0, N);
    	
    	System.out.println(white_paper + "\n" + blue_paper);
    }
    
    public static void cutPaper(int row, int col, int n) {
    	if(n == 1) {
    		if(paper[row][col] == 1) blue_paper++;
    		else white_paper++;
    		return;
    	}
    	
    	for(int i = row; i < row + n; i++) {
    		for(int j = col; j < col + n; j++) {
    			if(paper[row][col] != paper[i][j]) {
    				cutPaper(row, col, n/2);
    	    		cutPaper(row, col + n/2, n/2);
    	    		cutPaper(row + n/2, col, n/2);
    	    		cutPaper(row + n/2, col + n/2, n/2);
    	    		return;
    			}
    		}
    	}

    	if(paper[row][col] == 1) {
    		blue_paper++;
    	} else {
    		white_paper++;
    	}
    	return;
    }

}