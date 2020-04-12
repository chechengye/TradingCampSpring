package com.weichuang.annotation;

import com.weichuang.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 四个注解的作用，将类动态的配置进Spring容器中，与之前的<bean></bean>一样
 * 对象默认的名称为类的首字母小写
 * @Component ：组件，用于vo,pojo包下的类
 * @Service : 作用于service层
 * @Repository :作用于dao层
 * @Controller : 作用于web/controller层
 *
 * @Component(value = "person1") : 起名，不常使用
 */
@Component
//@Service
//@Repository
//@Controller
public class Person {

    //通过反射的原理进行注入，不推荐，破坏了Java的封装性
    //@Value("zhaoliu")
    private String name;
    //@Value("11")
    private int age;
    /*
         @Autowired ：自动装配/自动注入 默认获取的是类的首字母小写的名称
         @Autowired
        @Qualifier(value = "car1") 它俩互相为组合注解。由Qualifier来决定获取的对象

        在企业中最常用的是@Autowired 因为通常对象只会有一个
     */
    /*@Autowired
    @Qualifier(value = "car1")*/
    @Resource(name = "car2")
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }
    @Value("wangwu")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Value("22")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
