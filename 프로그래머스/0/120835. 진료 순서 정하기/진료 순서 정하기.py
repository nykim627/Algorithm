def solution(emergency):
    sorted_lis = sorted(emergency)
    sorted_lis.reverse()
    answer = []
    for i in emergency:
        answer.append(sorted_lis.index(i)+1)
    return answer