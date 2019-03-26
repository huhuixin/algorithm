package com.hhx.leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * @author hhx
 */
public class P0922SortArrayByParity2 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution()
                        .sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int[] B = new int[A.length];
            int indexEven = 0, indexOdd = 1;
            for (int i : A) {
                if(i % 2 == 0){
                    B[indexEven] = i;
                    indexEven += 2;
                }else{
                    B[indexOdd] = i;
                    indexOdd += 2;
                }
            }
            return B;
        }
    }
}


