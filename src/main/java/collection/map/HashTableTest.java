package collection.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/27
 */
public class HashTableTest {
    public static void main(String[] args) {
        // 方法基本都被synchronized修饰 线程安全 基本已被抛弃,k和v都不允许放null
        Map<String, Integer> table = new Hashtable<>();
        table.put("11", 1);
    }
}
