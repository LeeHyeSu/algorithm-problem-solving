def solution(str1, str2):
    s1 = [str1[i:i+2].lower() for i in range(len(str1)-1) if str1[i:i+2].isalpha()]
    s2 = [str2[i:i+2].lower() for i in range(len(str2)-1) if str2[i:i+2].isalpha()]
    
    inter = 0
    union = 0
    
    for s in set(s1 + s2):
        inter += min(s1.count(s), s2.count(s))
        union += max(s1.count(s), s2.count(s))
        
    if union == 0:
        return 65536
    else:
        return int(inter/union * 65536)