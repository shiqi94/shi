package bean1;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){}
}
