package com.weichuang.pojo;

public class User {
    private String name;
    private int age;
    private Car car;
    //默认的空参构造方法是一些反射机制要用到的，需要补全
    public User() {}

    public User(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(int age , String name) {
        this.name = name;
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init(){
        System.out.println("初始化方法！");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
