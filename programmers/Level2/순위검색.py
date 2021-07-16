from itertools import combinations
from collections import defaultdict
from bisect import bisect_left

def solution(info, query):
    answer = []
    info_dict = defaultdict(list)
    
    for i in info:
        temp = i.split()
        score = int(temp[-1])
        info_dict[''.join(temp[:-1])].append(score)
        for j in range(4):
            candi = list(combinations(temp[:-1], j))
            for c in candi:
                info_dict[''.join(c)].append(score)
    
    for i in info_dict:
        info_dict[i].sort()
        
    for i in query:
        key = i.split()
        score = int(key.pop())
        key = ''.join(key)
        key = key.replace('and', '').replace(' ', '').replace('-', '')
        answer.append(len(info_dict[key]) - bisect_left(info_dict[key], score))
    
    return answer