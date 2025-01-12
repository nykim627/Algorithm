def solution(numer1, denom1, numer2, denom2):
    final_numer = numer1*denom2 + numer2*denom1
    final_denom = denom1*denom2
    q, r = final_numer, final_denom			# 유클리드 호제법으로 두 수의 최대공약수 구하기
    while q%r:
        q, r = r, q%r   # q%r이 0이 될 때의 r이 최대공약수
    answer = [final_numer//r, final_denom//r]
    return answer