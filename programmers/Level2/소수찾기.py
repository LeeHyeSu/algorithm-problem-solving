import math
from itertools import permutations

def isPrime(number):
    if number in [0, 1]:
        return False
    
    for i in range(2, int(math.sqrt(number))+1):
        if number % i == 0:
            return False
        
    return True

def solution(numbers):
    answer = []
    
    for i in range(1, len(numbers)+1):
        perm = list(map(''.join, permutations(list(numbers), i)))
        for j in range(len(perm)):
            num = int(perm[j])
            if isPrime(num):
                answer.append(num)

    answer = list(set(answer))
    return len(answer)