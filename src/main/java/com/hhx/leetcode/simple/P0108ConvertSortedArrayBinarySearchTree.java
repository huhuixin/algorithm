package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author hhx
 */
public class P0108ConvertSortedArrayBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(
            new Solution().sortedArrayToBST(new int[]{-10,-3,0,5,9})
        );
    }

    /**
     * 思路, 对有序数组进行一分为2分别作为左右子树
     */
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int l, int r) {
            if(l > r){
                return null;
            }
            if(l == r){
                return new TreeNode(nums[l]);
            }
            int mid = (l + r)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, l, mid-1);
            root.right = buildTree(nums, mid + 1, r);
            return root;
        }
    }
}
