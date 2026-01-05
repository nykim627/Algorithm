-- 코드를 작성해주세요
SELECT T1.id, T2.fish_name, T1.length
FROM fish_info T1
JOIN fish_name_info T2
ON T1.fish_type = T2.fish_type
WHERE (T1.fish_type, T1.length) in (  -- 다중컬럼 in 사용!
    SELECT fish_type, MAX(length)
    FROM fish_info
    GROUP BY fish_type
)

-- 서브 쿼리 작성!
# SELECT T1.id, T2.fish_name, T1.length
# FROM fish_info T1
# JOIN fish_name_info T2
# ON T1.fish_type = T2.fish_type
# WHERE T1.length = any(SELECT MAX(length)
# FROM fish_info
# GROUP BY fish_type)
# ORDER BY T1.id


-- 궁금한 점: 왜 join, on 말고 FROM에서 T1, T2 모두 쓰면 안되지...? -> 카타시안 곱이 나오는 이유가 궁금함
# SELECT T1.id, T2.fish_name, T1.length
# FROM fish_info T1, fish_name_info T2
# WHERE T1.length = any(SELECT MAX(length)
# FROM fish_info
# GROUP BY fish_type)