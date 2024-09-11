package com.LeetCode;

/**
 * @Description: 学生出勤记录
 * @Author : yandg
 * @Date 2024/9/10 星期二
 */
public class StudentsAttendance {
    public static void main(String[] args) {
        String record = "PPALLL";

        Boolean result = checkRecord(record);
        System.out.println(result);
    }

    private static Boolean checkRecord(String record) {
        int countA =0;
        int countL =0;
        char[] chars = record.toCharArray();
        for(char c:chars){
            if(c=='A'){
                countA++;
            }
        }
        if(record.contains("LLL")){
            countL=3;
        }

        if(countA>=2 ||  countL>=3){
            return false;
        }else {
            return true;
        }
    }
}
