package test.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",22222);

            System.out.println("请输入--------");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String ins = scanner.next();
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(ins.getBytes());
                outputStream.flush();
                System.out.println("发送完成");
            }

        } catch (IOException e) {

        }


    }
}
