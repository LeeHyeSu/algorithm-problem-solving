from collections import deque

def solution(maps):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    n, m = len(maps), len(maps[0])
    
    queue = deque()
    queue.append([0, 0])
    
    graph = [[-1 for _ in range(m)] for _ in range(n)]
    graph[0][0] = 1
    
    while queue:
        y, x = queue.popleft()
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] == 1:
                if graph[ny][nx] == -1:
                    graph[ny][nx] = graph[y][x] + 1
                    queue.append([ny, nx])
    
    return graph[-1][-1]