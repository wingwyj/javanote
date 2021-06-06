import com.google.common.base.Function;
import org.omg.CORBA.INTERNAL;

/**
 * 函数式编程
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 17:32
 */
public class function {
    public static void main(String[] args) {
        function();
    }
    static void function() {
        Function<Integer, String> function = (key)-> "AA";
        System.out.println(function.apply(11));
    }
}
