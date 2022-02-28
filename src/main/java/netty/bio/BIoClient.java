package netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * 阻塞IO client
 *  client每隔2秒发送一次hello world
 */
public class BIoClient {
    public static void main(String[] args) {
        new Thread(()-> {
            OutputStream outputStream = null;
            try {
                // 连接到目标服务器
                Socket client = new Socket("127.0.0.1", 8080);
                while (true) {
                    try {
                        outputStream = client.getOutputStream();
                        outputStream.write((new Date() + ": hello world").getBytes());
                        outputStream.flush();
                        Thread.sleep(2000);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
