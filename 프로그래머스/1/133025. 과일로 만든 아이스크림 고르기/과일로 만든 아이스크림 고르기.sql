-- 코드를 입력하세요
-- innor join 연습!
SELECT i.flavor as FLAVOR
FROM first_half f
INNER JOiN icecream_info i
ON f.flavor = i.flavor
WHERE f.total_order > 3000 
AND i.ingredient_type = 'fruit_based'