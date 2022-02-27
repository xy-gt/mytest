package test.excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;

import java.util.*;

/**
 * @Author xiongyong
 * @Date 2021/8/17
 */

public class TestExcelOutput {

    public static void main(String[] args) {
        Map<Object, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());
        row1.put("考试日期2", DateUtil.date());
        row1.put(1, "ssss");
        row1.put(2, "aa");
        row1.put(3, "rre");



        Map<Object, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());
        row2.put(1, "vas");
        row2.put(3, "trr");


        Map<Object, Object> row3 = new LinkedHashMap<>();
        row3.put("姓名", "王五");
        row3.put("成绩", 59.50);
        row3.put("是否合格", false);
        row3.put(1, "bbss");


        ArrayList<Map<Object, Object>> rows = CollUtil.newArrayList(row1, row2,row3);

       //List<Map> rows = JSON.parseArray("[{\"groupName\":\"分组(人)/权限/项目\",\"guser\":\"\",465:\"test-p-4\",478:\"tets-p-5\",463:\"test-g-1/test-p-2\"},{\"groupName\":\"full\",\"guser\":\"\",463:\"MAINTAINER\"},{\"groupName\":\"full\",\"guser\":\"\",465:\"MAINTAINER\"},{\"groupName\":\"yutj41337\",\"guser\":\"\",463:\"REPORTER\"},{\"groupName\":\"full\",\"guser\":\"\",478:\"MAINTAINER\"},{\"groupName\":\"group-1\",\"guser\":\"张思萍(zhangsp41338),王炜嘉(wangwj41339),熊勇(xiongyong33672)\",465:\"Guest\"},{\"groupName\":\"group-2\",\"guser\":\"\",465:\"DEVELOPER\"},{\"groupName\":\"group-3\",\"guser\":\"\",478:\"MAINTAINER\"}]", Map.class);

        //通过工具类创建writer
        UUID uuid = UUID.randomUUID();
        ExcelWriter writer = ExcelUtil.getWriter("d:/"+uuid+".xlsx");

//跳过当前行，既第一行，非必须，在此演示用
       // writer.passCurrentRow();

//合并单元格后的标题行，使用默认标题样式
        //writer.merge(row1.size() - 1, "测试标题");
        writer.merge(1,1,0,1,null,false);
        writer.merge(3,3,0,1,null,false);
//一次性写出内容，强制输出标题

        Font font = writer.createFont();
        font.setBold(false);
        font.setColor(Font.COLOR_NORMAL);
        font.setItalic(false);
        font.setFontName("微软雅黑");
        //第二个参数表示是否忽略头部样式
        writer.getStyleSet().setFont(font, false);
        writer.getStyleSet().setWrapText();
        writer.getCellStyle().setBorderTop(BorderStyle.NONE);
        writer.getCellStyle().setBorderLeft(BorderStyle.NONE);
        writer.getCellStyle().setBorderRight(BorderStyle.NONE);
        writer.getCellStyle().setBorderBottom(BorderStyle.NONE);


        writer.write(rows, true);
        writer.merge(0,0,0,row1.size(),"产品维度-git权限列表",true);
        writer.autoSizeColumnAll();
        writer.setColumnWidth(1,30);
      //关闭writer，释放内存
        writer.close();
    }
}
