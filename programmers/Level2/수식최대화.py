from itertools import permutations

def calc(priority, n, expression):
    if n == 2:
        return str(eval(expression))
    
    op = priority[n]
    return str(eval(op.join([calc(priority, n+1, e) for e in expression.split(op)])))

def solution(expression):
    answer = 0
    priorities = list(permutations(['*','+','-'], 3))
    
    for priority in priorities:
        result = abs(int(calc(priority, 0, expression)))
        answer = max(answer, result)
            
    return answer