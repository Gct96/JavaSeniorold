package com.atguigu.java;

/**
 * 使用enum关键字定义枚举类，默认继承于java.lang.Enum类
 * @author KeyboardHero
 * @create 2021-10-15 16:34
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn);
        autumn.show();
        System.out.println(Season1.class.getSuperclass());
        System.out.println("**********");
        //values():
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("**********");
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        Season1 winter=Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();

    }

}

interface Info{
    void show();
}
enum Season1 implements Info{
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("这是一个秋季");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("这是一个冬季");
        }
    };
    //声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;
    //私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    //其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }



    //其他诉求：提供toString()
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
