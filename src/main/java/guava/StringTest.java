package guava;

import sun.security.action.PutAllAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/9 21:54
 */
public class StringTest {
    public static void main(String[] args) {
        String key = "aa";

        Map<String, String> map = new HashMap();
        map.put(key, "AA");

        key = "bb";

        System.out.println(map.get(key));
    }
}
