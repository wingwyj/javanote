package map;

import java.util.IdentityHashMap;

/**
 * @ Author wyj
 * @ Date 2022/3/15
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<Integer, Integer> map = new IdentityHashMap<>();
        map.put(new Integer(1),11);
        map.put(new Integer(1),11);
        System.out.println(map.toString());
    }
}
