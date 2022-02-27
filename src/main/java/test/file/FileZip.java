package test.file;

import cn.hutool.core.util.ZipUtil;

import java.io.IOException;

public class FileZip {

    public static void main(String[] args) throws IOException {

        // boolean true 生成目录； false 直接进入文件
        ZipUtil.zip("/D:\\ideaworkspace\\mytest\\src\\main\\java\\test\\file\\a.abc",
                "D:\\ideaworkspace\\mytest\\src\\main\\java\\test\\file\\a.zip",false);

    }

}
