package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一
 * 致、长度为 0 的空数组。
 * @ Author wyj
 * @ Date 2023/2/27
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");

        String[] strings = list.toArray(new String[0]);

    }
}
