-- 코드를 입력하세요
SELECT T1.rest_id, rest_name, food_type, favorites, address, score
FROM rest_info T1
JOIN (
    SELECT rest_id, ROUND(AVG(review_score),2) AS score 
    FROM rest_review 
    GROUP BY rest_id) T2
ON T1.rest_id = T2.rest_id
WHERE address LIKE '서울%'
ORDER BY score DESC, favorites DESC


# SELECT rest_id, rest_name, food_type, favorites, address, avg(review_score) AS score



# # SELECT avg(review_score) AS score
# # FROM rest_review
# # WHERE T1.rest_id = rest_review.rest_id

# SELECT * from rest_info WHERE address LIKE '서울%'