-- 코드를 작성해주세요
SELECT T1.item_id, item_name, rarity
FROM item_info T1
JOIN item_tree T2
ON T1.item_id = T2.item_id
WHERE NOT EXISTS (  -- item_tree의 parent ID와 같은 item_id가 '존재하지 않는지'를 행별로 확인
    SELECT 1
    FROM item_tree
    WHERE parent_item_id = T1.item_id   -- 상호연관 서브 쿼리(외부 쿼리에 있는 테이블에 대한 참조를 하는 서브 쿼리)
)
ORDER BY T1.item_id DESC

-- 원래 생각했던 코드는 아래. in만 있을때는 결과가 잘 나왔는데 not in으로 바꾸니 안나옴.
-- NOT IN은 서브쿼리 결과에 NULL이 포함되면 항상 결과를 반환하지 않는다고 함.(not in은 null에 매우 취약.) 따라서 null에 영향받지 않는 not exists를 써야 한다. 실무에서도 not in보다 not exists를 더 선호한다고...
# SELECT item_id
# FROM item_info
# WHERE item_id not in(
# SELECT DISTINCT parent_item_id
# FROM item_tree)