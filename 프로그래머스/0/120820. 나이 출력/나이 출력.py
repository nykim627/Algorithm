def solution(age):
    if age<=22:
        answer = 2022-age+1
    else:
        answer = (2000-age+1)+22
    return answer