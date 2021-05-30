import java.util.*;

/*
 * 다익스트라 알고리즘을 이용하여 최단거리를 구하는 문제
 * : 현재 저장된 거리와 새로 도달가능한 거리를 비교해 최단거리를 갱신해나감
 * - 우선순위 큐
 * - 인접리스트 사용
 */
class Solution { 
    class Edge implements Comparable<Edge> {
        int to, weight;
        
        Edge (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    List<List<Edge>> graph = new ArrayList<>();
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        pq.offer(new Edge(1, 0));
        
        dijkstra();
        
        for (int distance : dist) {
            if (distance <= K) answer++;
        }
        
        return answer;
    }
    
    void dijkstra() {
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            for (Edge ne : graph.get(e.to)) {
                if (dist[ne.to] > dist[e.to] + ne.weight) {
                    dist[ne.to] = dist[e.to] + ne.weight;
                    pq.offer(ne);
                }
            }
        }
    }
    
}