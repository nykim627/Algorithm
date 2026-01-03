SELECT title, T1.board_id, reply_id, T2.writer_id, T2.contents, DATE_FORMAT(T2.created_date, '%Y-%m-%d') created_date
FROM used_goods_board T1
JOIN used_goods_reply T2
ON T1.board_id = T2.board_id
WHERE YEAR(T1.created_date)=2022 AND MONTH(T1.created_date)=10
ORDER BY T2.created_date, title
