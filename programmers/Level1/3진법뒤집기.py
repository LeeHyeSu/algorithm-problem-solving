def solution(n):
    answer = ''
    
    while n > 0:
        n, mod = divmod(n, 3)  
        answer += str(mod)

    return int(answer, 3)

# divmod(x, y) : x를 y로 나눈 몫과 나머지를 반환
# int(x, base) : base 진법으로 구성된 str 형식의 수를 10진법으로 변환