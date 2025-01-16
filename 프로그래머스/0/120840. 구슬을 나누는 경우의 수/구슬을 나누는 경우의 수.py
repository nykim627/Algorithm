def solution(balls, share):
    n1 = 1
    n2 = 1
    n3 = 1
    for i in range(1,balls+1):
        n1 = n1*i
    for i in range(1,share+1):
        n2 = n2*i
    for i in range(1, (balls-share)+1):
        n3 = n3*i
    answer = n1/(n2*n3)
    return answer