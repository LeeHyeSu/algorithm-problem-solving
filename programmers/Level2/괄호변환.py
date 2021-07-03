def isRight(p):
    count = 0
    
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
            
    return True

def divide(p):
    count = 0
    
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return p[:i + 1], p[i + 1:]
        

def solution(p):
    answer = ''
    
    if p == '':
        return answer
    
    u, v = divide(p)

    if isRight(u):
        answer = u + solution(v)
    else:
        answer += '(' + solution(v) + ')'
        
        for k in u[1:-1]:
            if k == '(':
                answer += ')'
            else:
                answer += '('
                
    return answer