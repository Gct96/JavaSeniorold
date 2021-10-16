package com.atguigu.java;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import org.junit.Test;

/**
 * @author KeyboardHero
 * @create 2021-10-06 16:26
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        Date date1=new Date(2020,9,80);
        System.out.println(date1);
    }

    /*
     1、localDateTime使用频率较高
     2、
     */



    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年月日时分秒
        LocalDateTime localDateTime1=LocalDateTime.of(2021,10,20,6,30);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());

        //体现不可变性
        LocalDate localDate1=localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    @Test
    public void test2(){
        //now()获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
     类似于SimpleDateFormat
     */

    @Test
    public void test3(){
        //方式一：预定义的标准格式
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
           //格式化:日期改成字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);
            //解析：字符串-->日期
        TemporalAccessor parse=formatter.parse("2021-10-10T22:29:46.535");
        System.out.println(parse);

        //方式二：本地化相关的格式
        DateTimeFormatter formatter1=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);//2021年10月10日 下午10时38分26秒
           //格式化
        String str2=formatter1.format(localDateTime);
        System.out.println(str2);


        //重点-方式三：自定义的格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2021-10-10 10:47:29
        //解析:字符串-->时间
        TemporalAccessor accessor = formatter3.parse("2021-10-10 10:47:29");
        System.out.println(accessor);
    }
}
