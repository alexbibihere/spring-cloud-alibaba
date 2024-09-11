package com.LeetCode;

import java.util.Arrays;

/**
 * @Description: 给定两个字符串str1和str2，找到两个字符串中不同的字符。
 * @Author : yandg
 * @Date 2024/9/10 星期二
 */
public class FindTwoStringDiff {
    public static void main(String[] args) {
            String str1 = "abcd";
            String str2 = "aebcd";
            String result = findDiff(str1, str2);
            System.out.println(result);
    }

    private static String findDiff(String str1, String str2) {
        // 两个字符串分割成字符数组 然后排序 然后按照字符数组的顺序比较 找到不同的字符 输出不同的字符
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i = 0; i < s1.length; i++) {
           if(s1[i] != s2[i]) {
               return String.valueOf(s2[i]);
           }
        }
        return "";
    }
}
