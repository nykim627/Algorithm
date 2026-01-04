-- 코드를 입력하세요
SELECT book_id, author_name, DATE_FORMAT(published_date, '%Y-%m-%d') published_date   -- 필요한 컬럼만 추출(모두 book에만 있는 컬럼명이므로 'b.' 필요없음. date_format 맞춰주기
FROM book b
INNER JOIN author a
ON b.author_id = a.author_id   -- author_id 기준 조인
AND b.category = '경제'   -- 카테고리가 '경제'인 도서만 뽑기
ORDER BY published_date  -- 출판일 기준 오름차순 정렬