package netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞io server
 */
public class BIoServer {
    public static void main(String[] args) throws Exception {
        // 创建一个socket 绑定端口8080
        ServerSocket serverSocket = new ServerSocket(8080);
        // 专门用来接收连接的线程
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方式获取新的连接
                    Socket socket = serverSocket.accept();
                    // 接收到新的连接 创建线程来读写
                    new Thread(() -> {
                        InputStream inputStream = null;
                        try {
                            byte[] data = new byte[1024];
                            inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                // 字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
