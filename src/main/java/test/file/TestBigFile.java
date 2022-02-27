package test.file;

import cn.hutool.core.date.StopWatch;

import java.io.*;

/**
 * @Author xiongyong
 * @Date 2021/8/3
 */

public class TestBigFile {
    public static void main(String[] args) throws IOException {
        StopWatch stopWatch = new StopWatch();

        String path = "D:\\软件\\ideaiuzxb.rar";
        stopWatch.start("task-1");
        FileInputStream inputStream = new FileInputStream(new File(path));
        stopWatch.stop();
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\a.zip"));

        stopWatch.start("task-2");
        byte[] bytes = new byte[512];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        stopWatch.stop();

        inputStream.close();
        outputStream.close();

        System.out.println(stopWatch.prettyPrint());
    }
}
