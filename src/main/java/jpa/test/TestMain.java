package jpa.test;

import jpa.domain.User;
import jpa.repository.UserDao;
import jpa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2017/9/15.
 */
public class TestMain {
    public static void main(String[] args) {
        //如果加载spring-context.xml文件：
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserDao userDao = (UserDao)context.getBean("userDao2");
        //userDao.delete(2);
        UserService userService = (UserService) context.getBean("userService");
        testSaveUser(userService);
        //testUpdateUser(userService);
        //User user = userService.findUserById(1);
        //userService.deleteUserById(1);
        //System.out.println(userService.findByGivenQuery("zzh2"));
        //System.out.println(userService.findByIdAndName(1, "zzh2"));
    }

    public static  void testSaveUser(UserService userService) {
        User user = new User();
        user.setName("李坏");
        user.setAge(222);


        userService.saveUser(user);
    }

    public static void testFindUserById(UserService userService) {
        Integer id = 1;
        User user = userService.findUserById(id);
        System.out.println(user);
    }

    public static void testUpdateUser(UserService userService) {
        User user = new User();
        user.setName("gdgs");
        user.setAge(232323);
        user.setId(12);
        //Integer id = 1;
        //User user = userService.findUserById(id);

        userService.updateUser(user);

    }

    public static void testDeleteUserById(UserService userService) {
        Integer id = 1;
        userService.deleteUserById(id);
    }



}
