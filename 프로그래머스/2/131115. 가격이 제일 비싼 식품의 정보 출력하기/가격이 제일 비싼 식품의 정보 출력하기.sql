-- 방1) limit 이용, 방2) 서브쿼리 이용
SELECT product_id, product_name, product_cd, category, price
FROM food_product
ORDER BY price DESC
LIMIT 1