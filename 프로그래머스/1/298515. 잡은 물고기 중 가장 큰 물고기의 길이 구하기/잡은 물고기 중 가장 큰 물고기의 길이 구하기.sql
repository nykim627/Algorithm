-- concat: 두 개 이상의 문자열들을 결합하여 반환
SELECT CONCAT(MAX(length),'cm') as max_length
FROM fish_info