import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        // 현재 날짜 구하기 (채점 기준 서버는 UTC+0)
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));

//        System.out.println(now); // 기본 포맷이 yyyy-mm-dd이므로 잘 나오지만 사용자 포맷 정의를 해보자

        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 포맷 적용
        String formattedNow = now.format(formatter);

        // 결과 출력
        System.out.println(formattedNow);

    }
}