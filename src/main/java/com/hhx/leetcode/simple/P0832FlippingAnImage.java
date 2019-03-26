package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Utils;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * @author hhx
 */
public class P0832FlippingAnImage {

    public static void main(String[] args) {
        Utils.countTime(() ->
            System.out.println(
                    Arrays.deepToString(new Solution().flipAndInvertImage(new int[][]{
                            new int[]{1, 1, 0, 0},
                            new int[]{1, 0, 0, 1},
                            new int[]{0, 1, 1, 1},
                            new int[]{1, 0, 1, 0}}))
            )
        );
        Utils.countTime(() ->
                System.out.println(
                        Arrays.deepToString(new Solution1().flipAndInvertImage(new int[][]{
                                new int[]{1, 1, 0},
                                new int[]{1, 0, 0},
                                new int[]{0, 1, 1},
                                new int[]{1, 0, 1}}))
                )
        );
    }

    /**
     * 思路: 翻转之后的坐标 取 抑或值
     */
    static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int length = A[0].length;
            int[][] B = new int[A.length][length];
            // 翻转之后的坐标是
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < length; j++) {
                    B[i][j] = A[i][length - 1 - j] ^ 1;
                }
            }
            return B;
        }
    }

    static class Solution1 {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int[] row : A) {
                for (int i = 0, j = row.length - 1; i <= j; ++i,--j) {
                    int t = row[i] ^ 1;
                    row[i] = row[j] ^ 1;
                    row[j] = t;
                }
            }
            return A;
        }
    }
}
