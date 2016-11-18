package bean;

/**
 * Created by Administrator on 2016/11/9 0009.
 */
//@Service
public class UseFunctionService {
//    @Autowired
//    FunctionService functionService;
//
//    public String SayHello(String word){
//        return functionService.sayHello(word);
//    }
    FunctionService functionService;
    public void setFunctionService(FunctionService functionService){
        this.functionService = functionService;
    }
    public String SayHello(String word){
        return  functionService.sayHello(word);
    }
}
