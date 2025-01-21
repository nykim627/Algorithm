def solution(numbers):
    answer = 0
    if len(numbers)==2:
        answer = numbers[0]*numbers[1]
    else:
        for idx, i in enumerate(numbers):
            tmp = numbers[:idx] + numbers[idx+1:]
            for j in tmp:
                if answer < i*j:
                    answer = i*j
    return answer