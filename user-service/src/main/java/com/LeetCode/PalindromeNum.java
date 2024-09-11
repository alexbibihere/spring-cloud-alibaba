package com.LeetCode;

/**
 * @Description:回文数
 * @Author : yandg
 * @Date 2024/9/11 星期三
 */
public class PalindromeNum {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(PalindNum(x));
    }

    private static boolean PalindNum(int x) {
        String b = String.valueOf(x);
        StringBuilder before = new StringBuilder(b);
        StringBuilder af = new StringBuilder(b);
        StringBuilder reverse = af.reverse();
        String after = reverse.toString();
        // 去除String负数的符号
        if(x < 0) {
            before = before.deleteCharAt(0);
        }
        if(before.toString().equals(after)) {
            return true;
        }
        return false;
    }
}
