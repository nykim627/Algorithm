-- 코드를 입력하세요
SELECT count(DISTINCT name)  -- count는 이름이 NULL인 경우는 집계하지 않음. distinct: 중복은 하나로
FROM animal_ins