package com.hhx.leetcode.simple;

/**
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 * @author hhx
 */
public class P0852PeakIndexInAMountainArray {

    public static void main(String[] args) {
        System.out.println(
            new Solution().peakIndexInMountainArray(new int[]{
                    0,2,1,0
            })
        );
    }

    /**
     * 二分查找法,找到一个 左右数字都比他小的数子的坐标
     */
    static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            return peakIndexInMountainArray(A, 0, A.length - 1);
        }

        /**
         * 在给定范围内查找目标
         */
        private int peakIndexInMountainArray(int[] A, int startIndex, int endIndex){
            int halfIndex = (startIndex + endIndex)/2;
            if(A[halfIndex] > A[halfIndex - 1]){
                if(A[halfIndex] > A[halfIndex + 1]){
                    return halfIndex;
                }else{
                    return peakIndexInMountainArray(A, halfIndex, endIndex);
                }
            } else {
                return peakIndexInMountainArray(A, startIndex, halfIndex);
            }
        }
    }
}
