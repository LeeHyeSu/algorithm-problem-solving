# # deque를 이용한 BFS 풀이
# from collections import deque
# def solution(numbers, target):
#     answer = 0
#     n = len(numbers)
#     queue = deque()
#     queue.append([numbers[0], 0])         # value, idx
#     queue.append([-1 * numbers[0], 0])    # value, idx
#     while queue:
#         temp, idx = queue.popleft()
#         idx += 1
#         if idx < n:
#             queue.append([temp + numbers[idx], idx])
#             queue.append([temp - numbers[idx], idx])
#         else:
#             if temp == target:
#                 answer += 1
#     return answer

# stack을 이용한 dfs 풀이
def solution(numbers, target):
    answer = 0
    n = len(numbers)
    stack = [[numbers[0], 0], [-1 * numbers[0], 0]]
    
    while stack:
        temp, idx = stack.pop()
        idx += 1
        if idx < n:
            stack.append([temp + numbers[idx], idx])
            stack.append([temp - numbers[idx], idx])
        else:
            if temp == target:
                answer += 1
                
    return answer