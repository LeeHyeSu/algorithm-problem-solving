def solution(s):
    length = []
    result = ''
    
    if len(s) == 1:
        return 1
    
    for size in range(1, len(s)//2 + 1):
        temp = s[:size]
        count = 1
        for i in range(size, len(s), size):
            if s[i:i+size] == temp:
                count += 1
            else:
                if count == 1:
                    count = ''
                result += str(count) + temp
                temp = s[i:i+size]
                count = 1
        if count == 1:
            count = ''
        result += str(count) + temp
        length.append(len(result))
        result = ''
    
    return min(length)