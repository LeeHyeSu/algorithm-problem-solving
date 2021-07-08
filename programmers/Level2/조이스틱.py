# 1. 모든 문자에 대해 A로부터의 거리와 Z로부터의 거리 중 작은 값 저장
# 2. left, right 각각 1씩 늘려가며 A가 아닌 문자에 먼저 도달하는 경우 찾기
# 3. left, right 중 더 짧은 거리의 위치로 이동하며 반복

def solution(name):
    moves = [min(ord(s) - ord('A'), ord('Z') - ord(s) + 1) for s in name]
    
    idx = 0
    answer = 0
    
    while True:
        answer += moves[idx]
        moves[idx] = 0
        
        if sum(moves) == 0:
            return answer
        
        left, right = 1, 1
        
        while moves[idx - left] == 0:
            left += 1 
            
        while moves[idx + right] == 0:
            right += 1
        
        if left >= right:
            idx += right
            answer += right
        else:
            idx -= left
            answer += left