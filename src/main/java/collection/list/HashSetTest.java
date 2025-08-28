package collection.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/27
 */
public class HashSetTest {
    public static void main(String[] args) {
        // hashset 基于hashmap实现
        Set<String> hashSet = new HashSet<>();
        // add方法只是调用了hashmap的put方法
        hashSet.add("aa");
    }
}
