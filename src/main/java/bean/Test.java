package bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
public class Test {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
//        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
//        System.out.println(useFunctionService.SayHello("di"));
//        context.close();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("java"));
        context.close();
    }
}
