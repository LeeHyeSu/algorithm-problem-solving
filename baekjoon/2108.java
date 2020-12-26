import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] cnt = new int[8001];
    	
    	for(int i = 0; i < N; i++) {
    		cnt[Integer.parseInt(br.readLine()) + 4000]++;
    	}
    	
    	double avg = 0.0;	// 산술평균
    	int median = 0;	 // 중앙값
    	int mode = 0;	// 최빈값
    	int range = 0;	// 범위
    	
    	int max = 0; int max_cnt = 0;
    	int front = 4000; int rear = -4000;
    	for(int i = 0; i < cnt.length; i++) {
    		if(cnt[i] > 0 ) {
    			// 최빈값 구하기
    			if(max < cnt[i]) {
    				max = cnt[i];
        			mode = i - 4000;
    			} 
    			// 첫번째 - 마지막 값 구하기
    			if(front == 4000) front = i - 4000;
    			rear = i - 4000;
    		}
    	}
    	range = rear - front;
    	
    	int mid = (N % 2 > 0) ? (N / 2 + 1) : N / 2;
    	for(int i = 0; i < cnt.length; i++) {
    		if(cnt[i] == max) {
    			// 최빈값이 여러개면 두 번째로 작은 값 출력
    			max_cnt++;
    			if(max_cnt == 2) mode = i - 4000;
    		}
    		while(cnt[i] > 0) {
    			avg += i - 4000;
    			
    			mid--;
    			if(mid == 0) median = i - 4000;

    			cnt[i]--;
    		}
    	}
    	avg = Math.rint(avg / N);
    	
    	System.out.println((int)avg + "\n" + median + "\n" + mode + "\n" + range);
    }
}