package thread.abc.abcSync;

/**
 * 顺序输出ABC
 *
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class AbcTest {
    public static void main(String[] args) {

    }

    /**
     * join方法实现
     */
    public static void testJoin() {
        Thread a = new Thread(new AbcThread("A"));
        Thread b = new Thread(new AbcThread("B"));
        Thread c = new Thread(new AbcThread("C"));

        try {
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testWait() {
        Thread a = new Thread(new AbcThread("A"));
        Thread b = new Thread(new AbcThread("B"));
        Thread c = new Thread(new AbcThread("C"));

        try {
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
