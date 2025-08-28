package collection.list;

import java.util.*;

/**
 * @ Author wyj
 * @ Date 2022/3/28
 */
public class SetTest {
    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.collectionToArray();
    }

    public void collectionToArray() {
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };

        List<String> list = Arrays.asList(s);
        System.out.println(list.toString());

        String[] array = list.toArray(new String[0]);
    }

    /**
     * 利用set集合去重
     */
    public void setTest() {
        List<Integer> list = Arrays.asList(1, 1, 3, 3, 2, 2, 4, 4, 5, 5, 6, 6);
        System.out.println(list.toString());
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set.toString());
    }
}
