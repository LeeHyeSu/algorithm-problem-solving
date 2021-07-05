# int 형의 list 를 map 을 사용하여 string 으로 치환한 뒤, list 로 변환
# 변환된 num 을 sort() 를 사용하여 key 조건에 맞게 정렬
# lambda x: x*3 은 num 인자 각각의 문자열을 3번 반복한다는 뜻
# x*3을 하는 이유 ? -> num 의 인수값이 1000 이하이므로 3자리 수로 맞춘 뒤, 비교
# 문자열 비교는 ASCII 값으로 치환되어 정렬됨
# 666, 101010, 222 의 첫번째 인덱스 값으로 비교하기 때문에
# 6 = 86, 1 = 81, 2 = 82 이므로 6 > 2 > 1 순
# sort() 의 기본 정렬 기준은 오름차순, reverse = True 전에 sort 된 결과값은 10, 2, 6
# 이를 reverse = True 를 통해 내림차순 해주면 6, 2, 10 이 되고
# ''.join(num) 을 통해 문자열로 합쳐준다
# 모든 값이 0 일 경우 처리를 위해 int 로 변환한 뒤, 또 str 로 변환

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    return str(int(''.join(numbers)))