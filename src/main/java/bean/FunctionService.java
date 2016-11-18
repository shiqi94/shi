package bean;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
@Repository
public class FunctionService {
    public String sayHello(String word){
        return "Hello"+word+"!";
    }
}
