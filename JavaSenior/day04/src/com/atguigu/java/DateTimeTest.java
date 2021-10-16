package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    /*Calendar日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //法一：创建子类GregorianCalendar的对象
        //法二：调用其静态方法getInsatance()
        Calendar calendar=Calendar.getInstance();
        //2.常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //gettime() 日历类-->Date
        Date date=calendar.getTime();
        System.out.println(date);

        //settime() Date-->日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }







}
