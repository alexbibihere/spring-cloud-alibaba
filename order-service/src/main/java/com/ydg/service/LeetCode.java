package com.ydg.service;

import java.util.Arrays;

/**
 * @Description:
 * @Author : yandg
 * @Date 2024/8/30 星期五
 */
public class LeetCode {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] array = twoSum(nums, target);
        System.out.println(Arrays.toString(array));
    }


        public static int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return  new int[]{i, j};
                    }
                }
            }
            return null;
        }
}
