package test.unit;

import com.google.common.collect.Lists;

import java.text.DecimalFormat;
import java.util.List;

/**
 * 文件大小转换
 *
 * @Author xiongyong
 * @Date 2020/12/10
 */

public class FileSizeConverUtil {

    private static List<String> unitList = Lists.newArrayList("BIT","B","KB","MB","GB","TB");

    public static String byteToOther(long val, String unit) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##"+"("+unit+")");
        if (val < 0 | !unitList.contains(unit)) {
            return "-1";
        }
        unit = unit.toUpperCase();
        float resVal = 0F;
        switch (unit) {
            case "BIT":
                resVal = val * 8F;
                break;
            case "B":
                resVal =  val;
                break;
            case "KB":
                resVal = val / 1024F;
                break;
            case "MB":
                resVal = val / (1024 * 1024F);
                break;
            case "GB":
                resVal = val / (1024 * 1024 * 1024F);
                break;
            case "TB":
                resVal = val / (1024 * 1024 * 1024 * 1024F);
                break;
            default:
               return "-1";
        }
        if (resVal > 0 && resVal <= 0.1) {
            int index = unitList.indexOf(unit);
            return byteToOther(val,unitList.get(index-1));
        }

        return decimalFormat.format(resVal);
    }

    public static void main(String[] args) {
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "BIT"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "B"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "KB"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "MB"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "GB"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "TB"));
        System.out.println(FileSizeConverUtil.byteToOther(524288000, "TB"));

    }
}
