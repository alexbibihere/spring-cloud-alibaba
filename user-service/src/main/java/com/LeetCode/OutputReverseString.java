package com.LeetCode;

/**
 * @Description: 输出反转字符串
 * @Author : yandg
 * @Date 2024/9/9 星期一
 */
public class OutputReverseString {
    public static void main(String[] args) {
        String str = "hello world";
        String reverseStr = reverseString(str);
        System.out.println(reverseStr);
    }

    public static String reverseString(String s) {
        // 本质是把字符串分割成数组 然后逐个交换
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
