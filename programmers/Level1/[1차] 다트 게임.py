def solution(dartResult):
    num = ''
    point = {'S':1, 'D':2, 'T':3}
    stack = []
    
    for i, d in enumerate(dartResult):
        if d in point:
            stack.append(int(num) ** point[d])
            num = ''
        elif d == '#':
            stack[-1] = stack[-1] * -1
        elif d == '*':
            stack[-1] = stack[-1] * 2
            if len(stack) >= 2:
                stack[-2] = stack[-2] * 2
        else:
            num += d
    
    return sum(stack)