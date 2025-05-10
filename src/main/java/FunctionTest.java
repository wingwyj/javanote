import org.junit.Test;

import java.util.function.Function;

/**
 * 函数式编程
 *
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 17:32
 */
public class FunctionTest {
    @Test
    public void functionTest() {
        Function<Integer, String> function = (key) -> "AA" + key;
        System.out.println(function.apply(11));
    }
}
