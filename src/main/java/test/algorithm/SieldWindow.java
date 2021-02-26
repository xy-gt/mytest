package test.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xiongyong
 * @Date 2021/2/25
 */

public class SieldWindow {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcdefgtkabihl");
        System.out.println(i);
    }
    //滑动窗口算法
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //窗口的左边是i，右边是j，下列算法将窗口的左右移动，截取出其中一段
        // try to extend the range [i, j]
        while (i < n && j < n) {
            //如果set中不存在该字母，就将j+1，相当于窗口右边向右移动一格，左边不动
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                //记录目前存在过的最大的子字符长度
                ans = Math.max(ans, j - i);
            } else {
                //如果set中存在该字母，则将窗口左边向右移动一格，右边不动，直到该窗口中不存在重复的字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

