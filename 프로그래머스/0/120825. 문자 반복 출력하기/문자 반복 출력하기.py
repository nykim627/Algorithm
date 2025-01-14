def solution(my_string, n):
    answer_list = []
    for i in my_string:
        answer_list.append(i*n)
    answer = ''.join(answer_list)
    return answer