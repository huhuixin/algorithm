package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.RandomUtil;
import com.hhx.leetcode.util.Utils;

import java.util.Arrays;

/**
 * 数组拆分 I
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * @author hhx
 */
public class P0561ArrayPartitionI {

    public static void main(String[] args) {
        Utils.compareTime(100,
                () -> new Solution().arrayPairSum(RandomUtil.randomIntArray(RandomUtil.randomEven(2, 10000), 0, 10000)),
                () -> new Solution1().arrayPairSum(RandomUtil.randomIntArray(RandomUtil.randomEven(2, 10000), 0, 10000)));
    }

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i < nums.length; i += 2) {
                count += nums[i];
            }
            return count;
        }
    }

    /**
     * 在数组规模较大的时候优势明显
     */
    static class Solution1 {
        public int arrayPairSum(int[] nums){
            int maxValue = 10000;
            int[] a = new int[maxValue * 2 + 1];
            int sum = 0;

            // 采用下标计数,实现排序 ,循环结束后 a[i] = n 代表 i 下标上有 n 个数字,
            // 且数字的值为 n - maxValue
            for(int i=0; i<nums.length; i++){
                a[nums[i] + maxValue]++;
            }

            // even 的目的是取 偶数位的值
            boolean even = false;
            for(int i=0; i<a.length; i++){
                while(a[i] > 0){
                    if(!even) {
                        // 还原值
                        sum += i - maxValue;
                    }
                    even = !even;
                    a[i]--;
                }
            }
            return sum;
        }
    }
}
