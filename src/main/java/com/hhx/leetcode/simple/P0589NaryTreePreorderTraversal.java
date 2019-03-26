package com.hhx.leetcode.simple;

import com.hhx.leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *               1
 *
 *      3        2        4
 *
 *    5  6
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * @author hhx
 */
public class P0589NaryTreePreorderTraversal {

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(3, 5, 6),
                new Node(2), new Node(4));
        System.out.println(
            new Solution().preorder(head)
        );
    }

    static class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorder(Node root) {
            if(root != null){
                list.add(root.val);
                if(root.children != null){
                    for (Node child : root.children) {
                        preorder(child);
                    }
                }
            }
            return list;
        }
    }
}
