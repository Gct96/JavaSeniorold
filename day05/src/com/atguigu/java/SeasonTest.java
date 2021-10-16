package com.atguigu.java;

/**
 * 一、枚举类的使用
 * 当需要定义一组常量时，可以使用枚举类
 * 如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 * 二、如何定义枚举类
 * 方式一：jdk5之前，自定义枚举类
 * 方式二：jdk5使用enum关键字
 * 三、Enum类中的常用方法
 *  values()方法:返回枚举类型的对象数组
 *  valueOf(String str):可以把一个字符串转为对应的枚举类对象
 *  toString():返回当前枚举类对象常量的名称
 * 四、使用枚举类实现接口
 *  情况一：定义接口，在enum类中实现抽象方法
 *  情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 * @author KeyboardHero
 * @create 2021-10-15 15:58
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring=Season.SPRING;
        System.out.println(spring);
    }
}
//自定义枚举类
class Season{
    //声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;
    //私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    //提供当前枚举类的多个对象
    public static final Season SPRING=new Season("春天","草长莺飞");
    public static final Season Summer=new Season("夏天","夏日炎炎");
    //其他诉求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他诉求：提供toString()
    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

}