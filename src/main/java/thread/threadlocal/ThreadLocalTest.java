package thread.threadlocal;

/**
 * @ Author wyj
 * @ Date 2022/4/28
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> th = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return 0;
            }
        };

        new Thread(()->{
            th.set(111);
            th.set(222);
            System.out.println("线程A " + th.get());
        }).start();

        System.out.println(th.get());
    }
}
