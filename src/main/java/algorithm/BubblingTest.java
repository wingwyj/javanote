package algorithm;

import java.util.Arrays;

/**
 * 冒泡算法
 *
 * @ Author wyj
 * @ Date 2022/7/4
 */
public class BubblingTest {
    public static void main(String[] args) {
        int[] array = {8, 9, 6, 2, 0, 1, 4, 7};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
