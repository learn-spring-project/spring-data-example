package configutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/8.
 */
@Configuration
@PropertySource(ignoreResourceNotFound = true,value = {
        "classpath:conf/db.properties",
        "classpath:conf/app.properties" //如果是相同的key，则最后一个起作用
})
@Component("configService")
//@ComponentScan(basePackages = "configutils")
public class ConfigService {
    @Autowired
    public Environment env;

}