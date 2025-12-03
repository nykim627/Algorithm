-- 코드를 작성해주세요
SELECT count(*) fish_count
FROM fish_info
WHERE fish_type = (SELECT fish_type FROM fish_name_info WHERE fish_name = 'BASS')
OR fish_type = (SELECT fish_type FROM fish_name_info WHERE fish_name = 'SNAPPER')