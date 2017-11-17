package com.spring.jpa;

import com.spring.jpa.entity.User;
import com.spring.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/11/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    ApplicationContext ctx;

    @Test
    public void testAddUser() {
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("李坏");
        user.setAge(111);
        userService.saveUser(user);
    }

    @Test
    public  void testFindUserById() {
        UserService userService = (UserService) ctx.getBean("userService");
        Long id = 1L;
        User user = userService.findUserById(id);
        System.out.println(user);
    }

    @Test
    public  void testUpdateUser() {
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("gdgs");
        user.setAge(232323);
        user.setId(1L);
        //Integer id = 1;
        //User user = userService.findUserById(id);

        userService.updateUser(user);

    }

    @Test
    public  void testDeleteUserById() {
        UserService userService = (UserService) ctx.getBean("userService");
        Long id = 1L;
        userService.deleteUserById(id);
    }

}
