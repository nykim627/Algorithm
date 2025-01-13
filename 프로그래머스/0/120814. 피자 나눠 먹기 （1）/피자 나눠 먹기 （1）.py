def solution(n):
    if n%7==0:
        answer = n//7
    else:
        answer = int(n/7)+1
    return answer