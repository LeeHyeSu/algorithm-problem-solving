import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {		
	/*
	 *  visited : 
	 *  행 = 화면에 있는 이모티콘 수 
	 *  열 = 클립보드에 있는 이모티콘 수 
	 */
	static boolean[][] visited = new boolean[1001][1001];
	
	static class Emoticon {
		int screen = 0;		// 화면에 있는 이모티콘 수 
		int clipboard = 0;	// 클립보드에 있는 이모티콘 수
		int time = 0;		// 걸린 시간
		
		Emoticon (int screen, int clipboard, int time) {	
			this.screen = screen;
			this.clipboard = clipboard;
			this.time = time;
		}
	}
	
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int s = Integer.parseInt(br.readLine());

    	bfs(s);	
    }
    
    static void bfs(int end) {
    	Queue<Emoticon> q = new LinkedList<>();
    	q.offer(new Emoticon(1, 0, 0));
    	visited[1][0] = true;
    	
    	while (!q.isEmpty()) {
    		Emoticon cur = q.poll();
    		
    		if (cur.screen == end) {
    			System.out.println(cur.time);
    			return;
    		}
    		
    		// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
    		q.offer(new Emoticon(cur.screen, cur.screen, cur.time + 1));
    		
    		// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
    		if (cur.clipboard != 0 && cur.screen + cur.clipboard <= end 
    				&& !visited[cur.screen + cur.clipboard][cur.clipboard]) {
    			q.offer(new Emoticon(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
    			visited[cur.screen + cur.clipboard][cur.clipboard] = true;
    		}
    		
    		// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
    		if (1 <= cur.screen && !visited[cur.screen - 1][cur.clipboard]) {
    			q.offer(new Emoticon(cur.screen - 1, cur.clipboard, cur.time + 1));
    			visited[cur.screen - 1][cur.clipboard] = true;
    		}
    	}
    }
}