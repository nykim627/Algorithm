import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalDateTime nowUTC = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(nowUTC.getYear());
        System.out.println(nowUTC.getMonthValue()<10 ? "0"+nowUTC.getMonthValue() : nowUTC.getMonthValue());
        System.out.println(nowUTC.getDayOfMonth());
    }
}