-- 코드를 입력하세요
SELECT book_id, author_name, DATE_FORMAT(published_date, '%Y-%m-%d') published_date
FROM book b
JOIN author a
ON b.author_id = a.author_id
WHERE b.category = '경제'
ORDER BY published_date

# SELECT * FROM book where category = '경제';