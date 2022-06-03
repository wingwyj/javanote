package jdk.math.random;

import java.util.Random;

/**
 * @ Author wyj
 * @ Date 2022/5/3
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(2);
        System.out.println(random.nextInt());
    }
}
