package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author KeyboardHero
 * @create 2021-10-15 15:35
 */
public class OtherClassTest {
    @Test
    public void test1(){
        BigInteger bi=new BigInteger("1243333333333333333333333333333333333333000");
        BigDecimal bd=new BigDecimal("123435.321");
        BigDecimal bd2=new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));//默认四舍五入保留3位小数
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));
    }
}
