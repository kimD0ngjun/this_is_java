package other;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        String formattedDate = simpleDateFormat.format(now);

        System.out.println(now);
        System.out.println(formattedDate);

        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar date = Calendar.getInstance(timeZone);

        int amPm = date.get(Calendar.AM_PM);

        String strAmPm;
        if (amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour = date.get(Calendar.HOUR);
        int minute = date.get(Calendar.MINUTE);
        int second = date.get(Calendar.SECOND);

        System.out.print(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.print(second + "초");

        System.out.println();

        // 시간대 아이디
        String[] timeZoneId = TimeZone.getAvailableIDs();
        for(String id : timeZoneId) {
            System.out.println(id);
        }
    }
}
