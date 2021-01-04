import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {		
	static int min = Integer.MAX_VALUE;
	static int[][] S;					
	static int N;	
	static boolean[] visit;
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	S = new int[N][N];
    	visit = new boolean[N];
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for(int j = 0; j < N; j++) {
    			S[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	combi(0, 0);
    	System.out.println(min);
    }
    
    // count는 조합 개수(=재귀 깊이), idx는 인덱스
    static void combi(int count, int idx) {
    	// 팀 조합이 완성될 경우
    	if(count == N/2) {
    		/*
    		 * 방문한 팀과 방문하지 않은 팀을 각각 나누어
    		 * 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
    		 */
    		diff();
    		return;
    	}
    	
    	for(int i = idx; i < N; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			combi(count + 1, i + 1);
    			visit[i] = false;
    		}
    	}
    }
    
    // 두 팀의 능력치 차이를 계산하는 함수
    static void diff() {
    	int team_start = 0;
    	int team_link = 0;
    	
    	for(int i = 0; i < N-1; i++) {
    		for(int j = i+1; j < N; j++) {
    			// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
    			if(visit[i] == true && visit[j] == true) {
    				team_start += S[i][j];
    				team_start += S[j][i];
    			}
    			// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
    			else if(visit[i] == false && visit[j] == false) {
    				team_link += S[i][j];
    				team_link += S[j][i];
    			}
    		}
    	}
    	
    	// 두 팀의 점수 차이 (절댓값)
    	int val = Math.abs(team_start - team_link);
    	
    	/*
    	 * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
    	 * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
    	 */
    	if(val == 0) {
    		System.out.println(val);
    		System.exit(0);
    	}
    	min = Math.min(val, min);
    }
}