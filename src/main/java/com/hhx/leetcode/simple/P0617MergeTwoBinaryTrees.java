package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.TreeNode;

/**
 * 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * @author hhx
 */
public class P0617MergeTwoBinaryTrees {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, 3, 2);
        node1.left.left = new TreeNode(5);

        TreeNode node2 = new TreeNode(2, 1, 3);
        node2.left.right = new TreeNode(4);
        node2.right.right = new TreeNode(7);

        System.out.println(node1);
        System.out.println(node2);

        System.out.println(
            new Solution().mergeTrees(node1, node2)
        );
    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null){
                if(t2 == null){
                    return null;
                }else{
                    t2.left = mergeTrees(null, t2.left);
                    t2.right = mergeTrees(null, t2.right);
                    return t2;
                }
            }else{
                if(t2 == null){
                    t1.left = mergeTrees(t1.left, null);
                    t1.right = mergeTrees(t1.right, null);
                    return t1;
                }else{
                    t1.left = mergeTrees(t1.left, t2.left);
                    t1.right = mergeTrees(t1.right, t2.right);
                    t1.val = t1.val + t2.val;
                    return t1;
                }
            }

        }
    }
}
