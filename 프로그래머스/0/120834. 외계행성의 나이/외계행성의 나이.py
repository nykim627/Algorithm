def solution(age):
    lis = []
    for i in str(age):
        if i=='0':
            lis.append('a')
        elif i=='1':
            lis.append('b')
        elif i=='2':
            lis.append('c')
        elif i=='3':
            lis.append('d')
        elif i=='4':
            lis.append('e')
        elif i=='5':
            lis.append('f')
        elif i=='6':
            lis.append('g')
        elif i=='7':
            lis.append('h')
        elif i=='8':
            lis.append('i')
        elif i=='9':
            lis.append('j')
    answer = ''.join(lis)
    return answer