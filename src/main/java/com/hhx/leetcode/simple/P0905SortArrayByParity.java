package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * @author hhx
 */
public class P0905SortArrayByParity {

    public static void main(String[] args) {
        Utils.countTime(() ->
            System.out.println(
                    Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4}))
            )
        );
    }

    /**
     * 偶数放到队首,
     */
    static class Solution {
        public int[] sortArrayByParity(int[] A) {
            int[] B = new int[A.length];
            int fontIndex = 0;
            int backIndex = A.length - 1;
            for (int i = 0; i < A.length; i++) {
                if(A[i] % 2 == 0){
                    B[fontIndex++] = A[i];
                }else{
                    B[backIndex--] = A[i];
                }
            }
            return B;
        }
    }
}
