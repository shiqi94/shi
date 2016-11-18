package bean1;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
