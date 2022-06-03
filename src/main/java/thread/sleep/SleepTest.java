package thread.sleep;

/**
 * @ Author wyj
 * @ Date 2022/5/24
 */
public class SleepTest {
    public static void main(String[] args) {
        new Thread(()->{
            TicketBean.getInstance().sellTickets();
        }, "AA").start();
        new Thread(()->{
            TicketBean.getInstance().sellTickets();
        }, "BB").start();
        new Thread(()->{
            TicketBean.getInstance().sellTickets();
        }, "CC").start();
    }
}
