# 최소공배수 문제
def solution(n):
    # 최대공약수A 구하기
    a = n
    b = 6
    while b%a:
        b, a = a, b%a
    A = a
    
    # 최소공배수B 구하기
    B = 6*(n/A)
    answer = B/6
    return answer