def solution(record):
    answer = []
    user = {}
    
    for message in record:
        if ('Enter' in message) | ('Change' in message):
            user[message.split(' ')[1]] = message.split(' ')[2]
            
    for message in record:
        if 'Enter' in message:
            answer.append(user[message.split(' ')[1]] + "님이 들어왔습니다.")
        elif 'Leave' in message:
            answer.append(user[message.split(' ')[1]] + "님이 나갔습니다.")
    
    return answer