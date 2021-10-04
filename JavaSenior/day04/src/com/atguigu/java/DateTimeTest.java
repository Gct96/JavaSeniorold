package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串2020-09-08转为java.sql.date
 * @author KeyboardHero
 * @create 2021-09-24 17:17
 */
public class DateTimeTest {
    @Test
    public void testExer() throws ParseException{
        String birth="2020-09-08";

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf1.parse(birth);

        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
}
