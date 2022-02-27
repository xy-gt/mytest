package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSocket {

    public static void main(String[] args) {

        try {
            System.out.println("服务器启动");
            ServerSocket serverSocket = new ServerSocket(22222);

            while (true) {
                Socket s = serverSocket.accept();

                new Thread(() -> {
                    InputStream inputStream = null;
                    try {
                        inputStream = s.getInputStream();
                        byte[] b = new byte[1024];
                        int i = 0;
                        while ((i = inputStream.read(b)) > 0  ) {
                            System.out.println(Thread.currentThread().getName()+":"+new String(b,0,i));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();


           }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
