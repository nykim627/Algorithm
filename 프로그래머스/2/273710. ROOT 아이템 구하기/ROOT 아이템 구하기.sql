-- 코드를 작성해주세요
SELECT T1.item_id, item_name
FROM item_info T1
JOIN item_tree T2
ON T1.item_id = T2.item_id
WHERE T2.parent_item_id IS NULL