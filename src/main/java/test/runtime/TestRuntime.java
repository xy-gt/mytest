package test.runtime;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ����Runtime 
 * @author panda *
 */
public class TestRuntime {

    public static void main(String[] args)  {
        //Java 执行shell 命令
        while (true) {
            System.out.println("请输入命令：");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            if ("exit".equals(command)) {
                break;
            }

            Process process;
            try {
                if (command == null || command == "") {
                    return;
                }
                process = Runtime.getRuntime().exec(command);

                InputStream  in = process.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while(read.readLine() != null) {
                    System.out.println(read.readLine());
                }
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
