package datasource.multi.ds;

import datasource.multi.ds.jpa.entity.User;
import datasource.multi.ds.jpa.entity.UserService;
import jpa.service.PersonService;
import jpa.spring.entities.Person;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Test {
    private ApplicationContext ctx = null;
    private UserService userService = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = ctx.getBean(UserService.class);
    }
/*    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate primaryJdbcTemplate = (JdbcTemplate) applicationContext.getBean("primaryJdbcTemplate");
        System.out.println(primaryJdbcTemplate.getDataSource().getConnection());
        UserService userService = (UserService)applicationContext.getBean(UserService.class);
        //primaryJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 111, "aaa", 20);

    }*/

    @org.junit.Test
    public void testPersonService(){
        User p1 = new User();
        p1.setAge(15);
        p1.setEmail("aa@163.com");
        p1.setLastName("AA");

        User p2 = new User();
        p2.setAge(16);
        p2.setEmail("bb@163.com");
        p2.setLastName("BB");

        System.out.println(userService.getClass().getName());
        userService.saveUsers(p1, p2);
    }

    @org.junit.Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
