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
ORDER BY T1.id