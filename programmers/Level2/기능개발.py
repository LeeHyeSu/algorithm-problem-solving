# # queue 를 활용한 풀이
# def solution(progresses, speeds):
#     answer = []
#     days = 0
#     count = 0
    
#     while len(progresses) != 0:
#         if progresses[0] + days * speeds[0] >= 100:
#             progresses.pop(0)
#             speeds.pop(0)
#             count += 1
#         else:
#             if count > 0:
#                 answer.append(count)
#                 count = 0
#             days += 1
    
#     answer.append(count)
#     return answer

# 소요 시간을 미리 계산해두기  - math.ceil 활용
import math

def solution(progresses, speeds):
    progresses = [math.ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    answer = []
    front = 0
    
    for idx in range(len(progresses)):
        if progresses[idx] > progresses[front]:
            answer.append(idx - front)
            front = idx
    
    answer.append(len(progresses) - front)
    return answer