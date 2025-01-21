# 입력 받기
a, b = map(int, input().split())  # 시와 분을 각각 정수로 입력받음
c = int(input())  # 요리 시간을 분으로 입력받음

# 현재 시간을 분 단위로 변환
total_minutes = a * 60 + b + c

# 종료 시간의 시와 분 계산
final_hour = (total_minutes // 60) % 24  # 시 계산, 24시간 형식으로 만들기 위해 % 24 사용
final_minute = total_minutes % 60  # 분 계산

# 결과 출력
print(final_hour, final_minute)
