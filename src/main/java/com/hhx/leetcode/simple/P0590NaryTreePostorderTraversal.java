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
public class P0590NaryTreePostorderTraversal {

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(3, 5, 6),
                new Node(2, 22), new Node(4));
        System.out.println(
            new Solution().postorder(head)
        );
    }

    static class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            each(root, list);
            return list;
        }

        private void each(Node node, List<Integer> list) {
            if(node != null){
                if(node.children != null){
                    for (Node child : node.children) {
                        each(child, list);
                    }
                }
                list.add(node.val);
            }
        }
    }

    static class Solution1 {
        List<Integer> list = new ArrayList<>();
        public List<Integer> postorder(Node root) {
            if(root != null){
                if(root.children != null){
                    for (Node child : root.children) {
                        postorder(child);
                    }
                }
                list.add(root.val);
            }
            return list;
        }
    }
}
