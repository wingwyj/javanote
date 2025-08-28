package map;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * TreeMap
 * TreeMap 是一个有序的key-value集合，它是按照提供的比较器进行比较，没有添加则使用默认比较器，注意这里的有序不是按照添加的顺序。
 * TreeMap 继承于AbstractMap，所以它是一个Map，即一个key-value集合。
 * TreeMap 实现了Cloneable接口，它能被克隆。实现了java.io.Serializable接口，它支持序列化。
 * TreeMap基于红黑树实现， containsKey、get、put 和 remove 的时间复杂度是 log(n) 。
 * TreeMap是线程不安全的。 它的iterator 方法返回的迭代器支持fail-fast机制。
 *
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/12 21:48
 */
public class TreeMapTest {
    public static void main(String[] args) {
        // Comparator.reverseOrder() 逆序treeMap
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(-1, 111);
        treeMap.put(3, 333);
        treeMap.put(2, 222);
        treeMap.put(4, 444);
        System.out.println(treeMap);
        ceilingEntry(treeMap);
        comparator(treeMap);
        descendingKeySet(treeMap);
        descendingMap(treeMap);
        floorEntry(treeMap);
        headMap(treeMap);
        higherEntry(treeMap);
        lastEntry(treeMap);
        lowerEntry(treeMap);
//        pollFirstEntry(treeMap);
        tailMap(treeMap);
    }

    /**
     * comparator()
     * 1）返回当前map的比较器
     * 2）如果采用的是増序 则返回null
     *
     * @param treeMap
     */
    static void comparator(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======comparator()======");
        Comparator<? super Integer> comparator = treeMap.comparator();
        System.out.println(treeMap.toString());
    }

    /**
     * descendingKeySet()
     * 返回当前map的逆序排列的key
     *
     * @param treeMap
     */
    static void descendingKeySet(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======descendingKeySet()======");
        System.out.println(treeMap.descendingKeySet());
    }

    /**
     * descendingMap()
     * 1）返回一个逆序排列的map
     *
     * @param treeMap
     */
    static void descendingMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======descendingMap()======");
        NavigableMap<Integer, Integer> map = treeMap.descendingMap();
        System.out.println(map);
    }

    /**
     * Map.Entry<K,V> ceilingEntry(K key)
     * 1）返回大于等于key的entry
     * 2）key不存在就返回null
     *
     * @param treeMap
     */
    static void ceilingEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======ceilingEntry()======");
        System.out.println(treeMap.ceilingEntry(2));
        System.out.println(treeMap.ceilingEntry(-2));
    }

    /**
     * floorEntry(K key)
     * 1）返回小等于key的value
     * 2）key不存在则返回null
     */
    static void floorEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======floorEntry()======");
        System.out.println(treeMap.floorEntry(6));
    }

    /**
     * headMap(K toKey) 返回key小于toKey的所有映射组成的map
     * headMap(K toKey, boolean inclusive) inclusive 是否包含其本身
     */
    static void headMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======headMap()======");
        System.out.println(treeMap.headMap(4, true));
    }

    /**
     * higherEntry(K key)
     * 1）返回大于key的第一个映射entry
     * 2）不存在的话返回null
     */
    static void higherEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======higherEntry()======");
        System.out.println(treeMap.higherEntry(55));
    }

    /**
     * lastEntry() 返回map中最后一个映射的entry，不存在则返回null
     *
     * @param treeMap
     */
    static void lastEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======lastEntry()======");
        System.out.println(treeMap.lastEntry());
    }

    /**
     * lowerEntry(K key)
     * 返回严格小于key的最大的映射value 不存在则返回null
     */
    static void lowerEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======lastEntry()======");
        System.out.println(treeMap.lowerEntry(4));
    }

    /**
     * pollFirstEntry()
     * 移除第一个映射,并返回该映射
     *
     * @param treeMap
     */
    static void pollFirstEntry(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======pollFirstEntry()======");
        System.out.println(treeMap.pollFirstEntry());
        System.out.println(treeMap);
    }

    /**
     * tailMap(K fromKey, boolean inclusive)
     * 1)返回大于fromKey的map集合
     * 2）inclusive 可选项 true包含fromKey false不包含fromKey
     * 3）inclusive可以不写默认为true
     * @param treeMap
     */
    static void tailMap(TreeMap<Integer, Integer> treeMap) {
        System.out.println("======tailMap()======" + treeMap.toString());
        System.out.println(treeMap.tailMap(0));
    }
}
