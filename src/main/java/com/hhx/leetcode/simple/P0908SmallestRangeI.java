package com.hhx.leetcode.simple;

/**
 * 最小差值 I
 *
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * @author hhx
 */
public class P0908SmallestRangeI {

    public static void main(String[] args) {
        System.out.println(
            new Solution().smallestRangeI(new int[]{1,3,6}, 1)
        );
    }

    /**
     * 这个题的意思是, 把一个数组里面的每个数组都加上一个  -K ~ K 之间
     * 的数字,使这个数组的最大值和最小值之间的差值最小,并返回这个最小的差值
     */

    static class Solution {
        public int smallestRangeI(int[] A, int K) {
            if(A.length < 2){
                return 0;
            }
            // 先找出最大值  min  最大值  max
            // 如果 max - K - (min + K) < 0 那最小差值就是 0 否则就是 max - K - (min + K) = max -min -2k
            int max = A[0], min = A[0];
            for (int i = 1; i < A.length; i++) {
                if(A[i] < min){
                    min = A[i];
                }else if(A[i] > max){
                    max = A[i];
                }
            }
            int res = max - min - 2 * K;
            return res < 0 ? 0 : res;
        }
    }
}
