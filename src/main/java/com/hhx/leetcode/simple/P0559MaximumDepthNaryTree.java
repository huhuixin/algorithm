package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Node;

/**
 * N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * @author hhx
 */
public class P0559MaximumDepthNaryTree {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(3, 5, 6),
                new Node(2), new Node(6));
        System.out.println(
            new Solution().maxDepth(node)
        );
    }

    static class Solution {
        public int maxDepth(Node root) {
            if(root == null){
                return 0;
            }
            if(root.children == null){
                return 1;
            }
            int maxChildLength = 0;
            for (Node child : root.children) {
                int temp = maxDepth(child);
                if(temp > maxChildLength){
                    maxChildLength = temp;
                }
            }
            return maxChildLength + 1;
        }
    }
}
