package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.TreeNode;

/**
 * 单值二叉树
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * @author hhx
 */
public class P0965UnivaluedBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(1, 1, 1), new TreeNode(1));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(1, 2, 1), new TreeNode(1));
        System.out.println(new Solution().isUnivalTree(treeNode1));
        System.out.println(new Solution().isUnivalTree(treeNode2));
    }

    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root.left == null) {
                if (root.right == null) {
                    return true;
                }else{
                    return root.val == root.right.val && isUnivalTree(root.right);
                }
            }else{
                if (root.right == null) {
                    return root.val == root.left.val && isUnivalTree(root.left);
                }else{
                    return root.val == root.right.val && isUnivalTree(root.right) && root.val == root.left.val && isUnivalTree(root.left);
                }
            }
        }
    }

}