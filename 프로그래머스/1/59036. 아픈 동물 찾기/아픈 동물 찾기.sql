SELECT animal_id, name   -- (1) 동물id와 이름 조회
FROM animal_ins
WHERE intake_condition = "Sick" -- 아픈동물 필터링
ORDER BY animal_id ASC  -- (2) animal_id 기준 오름차순 정렬(특별한 말 없으면 오름차순)