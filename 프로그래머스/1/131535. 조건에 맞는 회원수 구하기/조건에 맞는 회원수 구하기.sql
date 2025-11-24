-- 코드를 입력하세요
SELECT count(*) as users
FROM user_info
WHERE year(joined)=2021 
AND age BETWEEN 20 AND 29 