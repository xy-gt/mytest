package test.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.LineHandler;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 获取git 仓库地址
 *
 */
public class TestFile2 {

    public static void main(String[] args) {
        String path = "D:\\ideaworkspace\\HEP\\HEP-core\\.git\\config";

        List<String> strings = FileUtil.readLines(path, Charset.defaultCharset());

        for (String string : strings) {

            if (string.contains("url = http")) {

                System.out.println(string);
            }
        }

        File file1 = new File("D:\\ideaworkspace\\HEP\\HEP-core\\.git\\HEAD");
        FileUtil.readLines(file1, Charset.defaultCharset(), new LineHandler() {
            @Override
            public void handle(String s) {
                if (s.contains("ref: refs/heads/")) {
                    int i = s.lastIndexOf("/");
                    System.out.println(s.substring(i+1));
                }
            }
        });

        Multimap linkedListMultimap = LinkedListMultimap.create();
        linkedListMultimap.put("a",1);
        linkedListMultimap.put("a",3);
        linkedListMultimap.put("a",2);
        linkedListMultimap.put("a",4);

        System.out.println(linkedListMultimap);

    }

}
