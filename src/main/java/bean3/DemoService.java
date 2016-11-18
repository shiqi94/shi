package bean3;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class DemoService {
    @Value("其他类的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
