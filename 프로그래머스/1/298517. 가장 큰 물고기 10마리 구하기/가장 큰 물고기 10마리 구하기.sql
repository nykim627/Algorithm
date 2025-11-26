-- 코드를 작성해주세요
SELECT id, length
FROM fish_info
ORDER BY length DESC, id  -- null이 있는 컬럼의 정렬은 어떻게?? (https://thinkcatlog.tistory.com/entry/SQL-ORDER-BY%EB%A5%BC-%ED%96%88%EC%9D%84%EB%95%8C-NULL%EC%9D%B4-%EC%9E%88%EC%9C%BC%EB%A9%B4-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%A0%95%EB%A0%AC%EB%90%A0%EA%B9%8C)
LIMIT 10