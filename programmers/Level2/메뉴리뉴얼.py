from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        combi = []
        for order in orders:
            combi += combinations(sorted(order), c)
        candi = Counter(combi)
        
        if candi: 
            max_cnt = max(list(candi.values()))
            if max_cnt < 2: continue
            
            for key in candi.keys():
                if candi[key] == max_cnt:
                    answer.append(''.join(key))
        
            
    return sorted(answer)