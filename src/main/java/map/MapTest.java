package map;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 16:43
 */
public class MapTest {
    public static void main(String[] args) {
        compute();
        computeIfAbsent();
        computeIfPresent();
        merge();
        putAll();
        putIfAbsent();
        replaceAll();
    }

    /**
     * 	7.replaceAll(BiFunction<? super K,? super V,? extends V> function)
     * 替换map中所有的value为function的结果
     */
    static void replaceAll() {
        Map<Integer, Integer> map = new HashMap<>(1 << 4);
        map.put(1, 11);
        map.put(2, 22);

        map.replaceAll((key, value)->33);
        System.out.println(map);
    }
    /**
     * 6.putIfAbsent(K key, V value)
     * 1）key对应的映射值为null时 put（key, value）返回value
     * 2）key对应value存在时 不操作 返回value
     */
    static void putIfAbsent() {
        Map<Integer, Integer> map = new HashMap<>(1 << 4);
        map.put(1, 11);
        map.put(2, 22);
        System.out.println(map.putIfAbsent(2, 33));
        System.out.println(map);
        System.out.println("========================");
    }
    /**
     * 5.putAll(Map<? extends K,? extends V> m)
     * 遍历传入的map 直接put(key, value) add or replace
     */
    static void putAll() {
        Map<Integer, Integer> map = new HashMap<>(1 << 4);
        map.put(1, 11);
        map.put(2, 22);
        Map<Integer, Integer> map1 = new HashMap<>(1 << 4);
        map1.put(1, 33);
        map1.put(4, 44);

        map.putAll(map1);
        System.out.println(map);
        System.out.println(map1);
        System.out.println("========================");
    }

    /**
     * 	4.merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
     * 	1)key的映射值为null时，put(key, value)
     * 	2)key的映射值不为null时，替换原来的value为BiFunction结果
     */
    static void merge() {
        Map<Integer, Integer> map = new HashMap<>(1 << 4);
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, null);
        System.out.println(map.merge(4, 5, (oldVal, newVal) -> oldVal + newVal));
        System.out.println(map);
        System.out.println("========================");
    }
    /**
     * 3.computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
     * 1）key对应的映射值不为null且BiFunction的结果不为null时，put(key, BiFunction结果) 返回新映射
     * 2）key对应的映射值不为null且BiFunction结果为null时 remove(key) 返回null
     * 3) key存在时，不进行操作 返回null
     */
    static void computeIfPresent() {
        Map<Integer, Integer> map = new HashMap<>(1 << 4);
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, null);

        System.out.println(map.computeIfPresent(3, (key, value) -> value));
        System.out.println(map.computeIfPresent(2, (key, value) -> null));
        System.out.println(map);
        System.out.println("========================");
    }

    /**
     * 2.computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
     * 1）当key对应的value不存在或者为null时 建立key和function执行结果的映射，返回新映射的value
     * 2）当key对应的映射存在时，返回key的映射值
     */
    static void computeIfAbsent() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, null);

        map.computeIfAbsent(4, key -> 33);
        System.out.println(map);
        System.out.println("========================");
    }

    /**
     * 1.compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
     * 1）BiFunction结果不为null时，put(key, BiFunction结果) add or replace old mapping 返回BiFunction结果
     * 2）BiFunction结果为null时，key存在时remove(key) 返回null；key不存在直接返回null
     */
    static void compute() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, null);

        System.out.println(map.compute(8, (key, value) -> {
            System.out.println("key:" + key);
            System.out.println("value:" + value);
            return 1;
        }));
        System.out.println(map);
        System.out.println("========================");
    }
}
