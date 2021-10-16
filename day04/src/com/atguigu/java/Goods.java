package com.atguigu.java;

/**
 * 商品类
 * @author KeyboardHero
 * @create 2021-10-12 9:54
 */
public class Goods implements  Comparable {
    private String name;
    private double price;

    public Goods(){
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明比较大小的方式
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
         Goods goods=(Goods)o;
         return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
