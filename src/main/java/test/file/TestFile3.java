package test.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.NioUtil;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 获取git 仓库地址
 *
 */
public class TestFile3 {

    public static void main(String[] args) throws IOException {
       String path = "C:\\Users\\hspcadmin\\Desktop\\1.go";
       String path2 = "C:\\Users\\hspcadmin\\Desktop\\3.go";

        FileInputStream inputStream = new FileInputStream(new File(path));

        FileOutputStream outputStream = new FileOutputStream(new File(path2));


        FileChannel channel = inputStream.getChannel();
        FileChannel channel1 = outputStream.getChannel();


        //long l = channel.transferTo(0, channel.size(), channel1);
        IoUtil.copyByNIO(inputStream,outputStream,IoUtil.DEFAULT_BUFFER_SIZE,null);

    }
}
