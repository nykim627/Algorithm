def solution(n):
    i=2
    answer = []
    while i!=0:
        if n%i==0:
            if n//i==1:
                if i not in answer:
                    answer.append(i)
                i=0
            else:
                if i not in answer:
                    answer.append(i)
                n = n//i
        else:
            i+=1
    return answer