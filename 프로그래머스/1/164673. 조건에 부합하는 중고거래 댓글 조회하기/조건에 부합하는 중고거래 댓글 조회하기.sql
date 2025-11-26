-- 코드를 입력하세요
SELECT board.title title, board.board_id board_id, reply.reply_id reply_id, reply.writer_id writer_id, reply.contents contents, DATE_FORMAT(reply.created_date, '%Y-%m-%d') created_date
FROM used_goods_board board
INNER JOIN used_goods_reply reply
ON board.board_id = reply.board_id
WHERE YEAR(board.created_date) = 2022
AND MONTH(board.created_date) = 10
ORDER BY reply.created_date, board.title