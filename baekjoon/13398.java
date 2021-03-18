import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] a = new int[n];
    	int[][] d = new int[n][2];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		a[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = a[0];
    	d[0][0] = d[0][1] = a[0];
    	
    	for (int i = 1; i < n; i++) {
    		/*
    		 * d[i][0] : 수를 제거하지 않은 경우의 최대값
    		 * 이전까지의 최대값 + 자기 자신의 합, 자기 자신 중의 최댓값
    		 * 
    		 * d[i][1] : 수를 제거한 경우, 제거하지 않은 경우 중의 최댓값
    		 * 자기 자신을 제거해야 할 경우 지금까지 수를 제거한 적이 없어야 하므로 d[i-1][0] 값을 가져 옴
    		 */
    		d[i][0] = Math.max(d[i - 1][0] + a[i], a[i]);
    		d[i][1] = Math.max(d[i - 1][1] + a[i], d[i - 1][0]);
    		
    		max = Math.max(max, Math.max(d[i][0], d[i][1]));
    	}

    	System.out.println(max);
    }

}