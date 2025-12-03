-- 코드를 작성해주세요
SELECT T1.item_id, T1.item_name, T1.rarity
FROM item_info T1, item_tree T2
WHERE T1.item_id = T2.item_id   -- INNER JOIN 절을 쓰지 않고, WHERE 절 만으로도 INNER JOIN이 가능
AND T2.parent_item_id IN (SELECT item_id FROM item_info WHERE rarity = 'RARE')  -- 서브쿼리
ORDER BY T1.item_id DESC  -- item_id 기준 내림차순

# SELECT item_id FROM item_info WHERE rarity = 'RARE'