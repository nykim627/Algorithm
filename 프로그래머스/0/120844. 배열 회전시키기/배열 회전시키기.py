def solution(numbers, direction):
    answer = []
    if direction == "right":
        answer = [numbers[-1]]
        for i in numbers[0:-1]:
            answer.append(i)
    if direction == 'left':
        answer = numbers[1:]
        answer.append(numbers[0])
    return answer