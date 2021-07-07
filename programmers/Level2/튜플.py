def solution(s):
    answer = []
    
    s = s[2:-2].split("},{")
    s = list(map(lambda x: x.split(","), s))
    s.sort(key=len)
    
    for i in s:
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
    
    return answer
# import re
# from collections import Counter 

# def solution(s):
#     s = Counter(re.findall('\d+', s))
#     return list(map(int, [k for k, v in sorted(s.items(), key=lambda x: x[1], reverse=True)]))