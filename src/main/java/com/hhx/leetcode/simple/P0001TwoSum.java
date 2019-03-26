package com.hhx.leetcode.simple;

import java.util.Arrays;

/**
 * @author huhuixin
 */
public class P0001TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
}
