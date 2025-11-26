-- 형질의 번호가 어떻게 부여되는 건가 했는데 이진수로 변환해서 각 자리 비트에 대응되는 것이었음 (오른쪽부터 1번, 2번, ...)
-- 이진수를 어떻게 비교하지...?
-- (1) genotype 자체를 이진수로 변환하는 방법 - 문제해결 못함...
-- (2) 풀이를 올려둔 블로그를 참고함.  비트연산자 &로 이진수와 비교.
-- https://wing-beat.tistory.com/140
-- https://velog.io/@hskhyl/SQL-%EA%B4%80%EB%A0%A8-%EC%9D%B4%EC%A7%84%EC%88%98-%ED%92%80%EC%9D%B4-%EC%A0%95%EB%A6%AC
SELECT count(*) as count
FROM ecoli_data
WHERE genotype & 5 > 0 AND genotype & 2 = 0