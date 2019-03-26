package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.TreeNode;

/**
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author hhx
 */
public class P0226InvertBinaryTree {



    public static void main(String[] args) {
        System.out.println(TreeNode.TEST);
        System.out.println(
            new Solution().invertTree(TreeNode.TEST)
        );
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }else if(root.left != null || root.right != null){
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }

    }
}
