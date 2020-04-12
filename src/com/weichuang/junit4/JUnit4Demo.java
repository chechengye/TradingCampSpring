package com.weichuang.junit4;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weichuang.annotation.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/weichuang/annotation/annotation.xml")
public class JUnit4Demo {
    @Autowired
    Person person;
    @Autowired
    JdbcTemplate jt;
    @Test
    public void testFn(){
        System.out.println(person);
    }
    @Test
    public void testFn1(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //相当于之前的QueryRunner对象
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        List<User> userList = jt.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        });
        System.out.println(userList);
    }

    @Test
    public void testFn2(){
        int rows = jt.update("update t_user set username = ? where id = ? ", "guanyu", 1);
        if(rows > 0){
            System.out.println("修改成功!");
        }
    }
}
