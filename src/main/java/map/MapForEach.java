package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author wyj
 * @ Date 2023/2/27
 */
public class MapForEach {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(1 << 4);
        map.put("aa", 1);
        map.put("bb", 2);
        map.put("cc", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }

        map.forEach((key, value) ->{
            System.out.println(key + "===" + value);
        });
    }
}
