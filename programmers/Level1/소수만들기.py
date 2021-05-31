from itertools import combinations

def isPrime(num):
    if num == 0 or num == 1:
        return False
    else:
        for n in range(2, int(num**0.5)+1):
            if num % n == 0:
                return False
        return True

def solution(nums):
    answer = 0
    comb = list(combinations(nums, 3))
    
    for arr in comb:
        if isPrime(sum(arr)):
            answer += 1

    return answer