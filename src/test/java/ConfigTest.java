import configutils.ConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/10/8.
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = "configutils")
public class ConfigTest {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    @Qualifier("configService")
    ConfigService configService;

    @Test
    public void getConfig(){
      //  ConfigService configService = (ConfigService)ctx.getBean("configService");
        System.out.println(configService.env.getProperty("password"));
    }
}
