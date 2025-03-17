package programs;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateFormating {
    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime local = LocalDateTime.now();
        System.out.println(local);


        long time = date.getTime();
        System.out.println(date + " : " + time);
        System.out.println(date + ":" + getLocalDateTime(time));
    }

    private static LocalDateTime getLocalDateTime(Long longTime) {
        Instant instant = Instant.ofEpochMilli(longTime);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
