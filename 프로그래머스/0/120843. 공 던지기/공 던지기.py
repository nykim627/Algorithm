def solution(numbers, k):
    answer = 0
    i = 1
    n = 0
    while i<k:
        if n<(len(numbers)-2):
            n = n+2
            i+=1
        elif n==(len(numbers)-2):
            n = 0
            i+=1
        elif n==(len(numbers)-1):
            n = 1
            i+=1
        if i==k:
            answer = numbers[n]
            break
    return answer