def solution(n):
    answer = 0
    k=1
    while(True):
        fact = 1
        for i in range(1,k+1):
            fact *= i
        if fact > n:
            answer = k-1
            break
        k+=1
    return answer