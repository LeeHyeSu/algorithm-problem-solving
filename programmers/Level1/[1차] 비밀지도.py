# bin(number) : 전달받은 integer 혹은 long integer 자료형의 값을 '0b'이 붙은 이진수(binary) 문자열로 반환
# index slicing을 하게되면, 0으로 시작하는 2진수의 0들이 사라지기 때문에 자리수를 맞춰줘야함 - rjust(len) / zfill(len)

def solution(n, arr1, arr2):
    answer = []
    for a1, a2 in zip(arr1, arr2):
        tmp = bin(a1 | a2)[2:]
        tmp = tmp.rjust(n)
        tmp = tmp.replace('1', '#')
        tmp = tmp.replace('0', ' ')
        answer.append(tmp)
    return answer