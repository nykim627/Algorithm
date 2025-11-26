-- 코드를 입력하세요
SELECT f.flavor as FLAVOR
FROM first_half f
INNER JOiN icecream_info i
ON f.flavor = i.flavor
WHERE f.total_order > 3000 
AND i.ingredient_type = 'fruit_based'