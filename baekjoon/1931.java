import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] arr = new int[N][2];
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		arr[i][0] = Integer.parseInt(st.nextToken());
    		arr[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 끝나는 시간이 가장 빠른 것을 선택해야 하므로 끝나는 시간 순으로 정렬
    	Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});  	
    	
    	int cnt = 0;
    	int endTime = -1;
    	for(int i = 0; i < N; i++) {
    		if(endTime <= arr[i][0]) {
    			cnt++;
    			endTime = arr[i][1];
    		}
    	}
    	
    	System.out.println(cnt);
    }
    
}