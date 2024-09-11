package com.LeetCode;

/**
 * @Description: 罗马数字转整数
 * @Author : yandg
 * @Date 2024/9/11 星期三
 */
public class RomaNumToInteger {

    public static void main(String[] args) {
        String[] sarry = {"III", "IV", "IX", "LVIII", "MCMXCIV","DCXXI"};
            int result = romanToInt(sarry[5]);
            System.out.println(result);
    }


    public static int romanToInt(String s) {
        int result = 0;
        int preValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));
            if (value < preValue) {
                result -= value;
            } else {
                result += value;
                preValue = value;
            }
        }
        return result;

    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

