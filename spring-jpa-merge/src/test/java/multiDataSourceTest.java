import datasource.multi.ds.jpa.PrimaryConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/10/31.
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class multiDataSourceTest {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    @Qualifier("")
    PrimaryConfig primaryConfig;
    @Test
    public void test() throws Exception {

        // 往第一个数据源中插入两条数据
   //     jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2111, "aaa", 20);
     //   jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 3111, "bbb", 30);
          jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 3111, "bbb", 30);

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
      //  Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));
        System.out.println(jdbcTemplate2.queryForObject("select count(1) from user", String.class));
        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
      //  Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

    }

}
