def solution(s):
    answer = 0
    arr = s.split()
    for i in range(len(arr)-1):
        if arr[i]!="Z":
            if arr[i+1]!="Z":
                answer+=int(arr[i])
    if arr[len(arr)-1]!="Z":
        answer+=int(arr[len(arr)-1])
    return answer