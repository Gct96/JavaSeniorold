package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author KeyboardHero
 * @create 2021-10-12 9:37
 */

public class CompareTest {
    /*
    comparable接口的使用举例：自然排序
     */
    @Test
    public void test1(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("dellMouse",43);
        arr[2]=new Goods("xiaomiMouse",12);
        arr[3]=new Goods("huaweiMouse",65);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    Comparator接口的使用：定制排序
    重写compare(object o1,object o2)方法，比较o1和o2的大小
     */
    @Test
    public void test3(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare( Object o1,Object o2) {
                if(o1 instanceof String && o2 instanceof String ){
                    String s1=(String) o1;
                    String s2=(String) o2;
                    return -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr=new Goods[6];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("dellMouse",43);
        arr[2]=new Goods("xiaomiMouse",12);
        arr[3]=new Goods("huaweiMouse",65);
        arr[4]=new Goods("huaweiMouse",224);
        arr[5]=new Goods("microsoftMouse",43);
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
