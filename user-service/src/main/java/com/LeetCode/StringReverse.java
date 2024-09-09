package com.LeetCode;

/**
 * @Description: 字符串反转
 * @Author : yandg
 * @Date 2024/9/6 星期五
 */
public class StringReverse {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String reverseWord (String str) {
        // write code here
         // 根据空格分割成字符串数组,然后遍历数组 ,长度大于1的反转 ,然后重新加空格拼接
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if (split.length == 0) return str;
        for(String str1 : split) {
            // 字符串长大等于1的不用反转 直接加到结果中 ,字符串大于1的反转然后加到
            if (str1.length() == 1) {
                sb.append(str1).append(" ");
            } else {
                StringBuilder builder = new StringBuilder();
                sb.append(builder.append(str1).reverse().append(" "));
            }
        }

        return sb.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(reverseWord("I am a programmer"));
    }

}
