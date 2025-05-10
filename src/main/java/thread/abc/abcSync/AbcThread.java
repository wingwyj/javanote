package thread.abc.abcSync;

/**
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class AbcThread implements Runnable {
    private final String string;

    public AbcThread(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        System.out.println(string);
    }
}
