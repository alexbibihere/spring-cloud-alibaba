package com.LeetCode;

/**
 * @Description: 两个字符串数字相加
 * @Author : yandg
 * @Date 2024/9/9 星期一
 */
public class TwoStringSums {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "56";


       int sum = addStrings(num1, num2);
       System.out.println(sum);
    }

    public static int addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1;
        int j = len2 - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
