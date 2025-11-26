-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT
FROM fish_info
WHERE length is null  -- 잡은 물고기의 길이가 10cm 이하일 경우에는 LENGTH 가 NULL