def solution(rsp):
    arr = []
    for i in rsp:
        if i=='2':
            arr.append('0')
        elif i=='0':
            arr.append('5')
        elif i=='5':
            arr.append('2')
    answer = ''.join(arr)
    return answer