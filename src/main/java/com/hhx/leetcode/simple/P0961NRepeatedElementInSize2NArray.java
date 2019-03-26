package com.hhx.leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 *
 * 提示：
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * @author hhx
 */
public class P0961NRepeatedElementInSize2NArray {

    public static void main(String[] args) {
        System.out.println(
            new Solution().repeatedNTimes(new int[]{1, 2, 3, 3})
        );
    }

    /**
     * 思路:
     *
     * 长度为 2N 有 N+1 个元素,且有一个元素重复N 次
     * 那么  去掉这个重复的元素后  变成成都为N 的数组中 有N 个元素, 即每个元素都不同
     *
     * 综上所述 只要找到有重复的元素即可
     * 考虑到这个元素重复了N次,所以 只需查找 0 - N + 2区间内 必有重复的元素
     */
    static class Solution {
        public int repeatedNTimes(int[] A) {
            int n = A.length / 2;
            Set<Integer> set = new HashSet<>(n + 1);
            for (int i = 0; i < n + 2; i++) {
                if (!set.add(A[i])) {
                    return A[i];
                }
            }
            return -1;
        }
    }

}
