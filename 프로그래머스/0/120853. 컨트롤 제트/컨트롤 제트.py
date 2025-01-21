def solution(s):
    arr = s.split()
    stack = []
    
    for value in arr:
        if value == "Z":
            if stack:  # 스택에 값이 있을 때만 취소
                stack.pop()
        else:
            stack.append(int(value))
    
    return sum(stack)
