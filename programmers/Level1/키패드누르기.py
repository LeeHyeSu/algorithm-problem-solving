def solution(numbers, hand):
    answer = ''
    keypad = [[1, 4, 7, '*'], [2, 5, 8, 0], [3, 6, 9, '#']]
    
    l = [0, 3]
    r = [2, 3]
    
    for num in numbers:
        if num in keypad[0]:
            answer += 'L'
            l = [0, keypad[0].index(num)]
        elif num in keypad[2]:
            answer += 'R'
            r = [2, keypad[2].index(num)]
        else:
            idx = keypad[1].index(num)
            
            dl = abs(l[0] - 1) + abs(l[1] - idx)
            dr = abs(r[0] - 1) + abs(r[1] - idx)
            
            if dl == dr:
                if hand == 'left':
                    answer += 'L'
                    l = [1, idx]
                else:
                    answer += 'R'
                    r = [1, idx]
            elif dl < dr:
                answer += 'L'
                l = [1, idx]
            else:
                answer += 'R'
                r = [1, idx]
                
    return answer