package test.runtime;

import cn.hutool.core.util.RuntimeUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 测试Runtime
 * @author panda *
 */
public class TestRuntime {

    public static void main(String[] args)  {
        //Java 执行shell 命令
        while (true) {
            System.out.println("输入命令:");
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
                // mvn 打包 cmd /c   cd D:\ideaworkspace\mytest && mvn clean package
                process = RuntimeUtil.exec(command);//Runtime.getRuntime().exec(command);

                InputStream  in = process.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                while(read.readLine() != null) {
                    System.out.println(read.readLine());
                }
                process.waitFor();
                process.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------end----------------");

    }

}
