package bean1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
@Configuration
@ComponentScan("bean1")
@EnableAspectJAutoProxy
public class AopConfig {

}
