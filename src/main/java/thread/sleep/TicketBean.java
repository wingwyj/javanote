package thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * @ Author wyj
 * @ Date 2022/5/24
 */
public class TicketBean {
    private TicketBean() {
    }

    private static class Instance {
        public static final TicketBean instance = new TicketBean();
    }

    public static TicketBean getInstance() {
        return Instance.instance;
    }

    private int ticketCount = 100;

    public void sellTickets() {
        while (true) {
            synchronized (TicketBean.class) {
                if (ticketCount > 0) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("线程%s、卖掉了第 %d 张票", threadName, ticketCount--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
