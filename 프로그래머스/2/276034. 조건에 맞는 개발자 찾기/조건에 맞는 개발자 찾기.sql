-- 단일 행 중첩 서브 쿼리 이용
-- 더 좋은 방법을 찾아보기
SELECT id, email, first_name, last_name
FROM developers
WHERE skill_code & (SELECT (code) FROM skillcodes WHERE name = 'Python') > 0
OR skill_code & (SELECT (code) FROM skillcodes WHERE name = 'C#') > 0
ORDER BY id


