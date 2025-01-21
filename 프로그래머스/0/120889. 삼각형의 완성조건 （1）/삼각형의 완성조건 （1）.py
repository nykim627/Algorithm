def solution(sides):
    answer = 0
    m = max(sides)
    s = sum(sides)-m  # 전체 합에서 최대값 뺌
    if m<s:
        answer=1
    else:
        answer=2
    return answer