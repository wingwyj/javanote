package date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;



/**
 *
 * 时间类总结
 * @ Author wyj
 * @ Date 2022/9/15
 */
public class DateTest {
    public static void main(String[] args) {
        int num = 2100000000 * 10;
        System.out.println(num);
        new DateTest().dateDemo();
    }

    /**
     * 1.java.sql.Date extends java.util.Date 前者多了与localDate的转换
     * 2.Date 中记录的是时间戳，不同的时区中可以显示对应时区域的时间
     * 3.SimpleDateFormat 线程不安全
     */
    public void dateDemo() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date.toString());
        System.out.println(time);

        // new SimpleDateFormat() 时默认设置了当前时区(东八区)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("东八区时间：" + format.format(date));
        System.out.println(format.getTimeZone().getDisplayName());
        System.out.println(format.getTimeZone().getID());

        // 东九区时间
        SimpleDateFormat tokyoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tokyoFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("东九区时间：" + tokyoFormat.format(date));
        System.out.println(tokyoFormat.getTimeZone().getDisplayName());
        System.out.println(tokyoFormat.getTimeZone().getID());

        try {
            // 时间戳转为Date
            SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = timestampFormat.format(time);
            Date parse = timestampFormat.parse(dateStr);

            System.out.println(dateStr);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date zero = new Date(0);
        System.out.println(format.format(zero));
    }

    /**
     * java8 出的更好的时间处理类 LocalDate LocalTime LocalDateTime
     */
    public void LocalDateDemo() {
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));
        System.out.println("格式化之后的时间: " + localDateTime.format(formatter));
        System.out.println(localDateTime);
    }

    /**
     * MySql中的datetime 和 timestamp
     * 1.datetime   8字节 不受时区影响 时间范围:‘1000-01-01 00:00:00’ ~ ‘9999-12-31 23:59:59’
     * 2.timestamp  4字节 受时区影响  时间范围：‘1970-01-01 00:00:01’ UTC ~ ‘2038-01-19 03:14:07’ UTC
     */
}
