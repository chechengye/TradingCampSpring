package com.weichuang.test;

import com.weichuang.annotation.Person;
import com.weichuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickStartDemo {

    @Test
    public void testFn(){
        /*
            获取到配置文件对象（容器对象）
            可以直接使用getBean方式获取
         */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //默认会根据名称查询配置文件
        User user = (User)applicationContext.getBean("user");
        User user1 = (User)applicationContext.getBean("user");
        System.out.println(user == user1);
        user.setName("zhangsan");
        user.setAge(18);
        System.out.println(user);
        //User user1 = new User();
    }

    /**
     * 测试注入
     */
    @Test
    public void testFn1(){
        //多态的自动向上转型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User)applicationContext.getBean("user2");
        System.out.println(user);
    }
    /**
     * 测试注解
     */
    @Test
    public void testFn2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/weichuang/annotation/annotation.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }
}
