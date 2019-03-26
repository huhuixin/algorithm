package com.hhx.leetcode.util;

/**
 * @author hhx
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return toString(this);
    }

    private static String toString(TreeNode node){
        return node == null ? "null" :
                        "(" + toString(node.left) +
                        " <- " +
                        node.val +
                        " -> " +
                        toString(node.right) + ")";
    }
    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, int left, int right) {
        this.val = val;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeftAndRight(int left, int right){
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    public static final TreeNode TEST;
    public static final TreeNode FULL;
    static {
        TEST = new TreeNode(3, 9, 20);
        TEST.right.setLeftAndRight(15, 7);

        FULL = new TreeNode(4, 2, 7);
        FULL.left.setLeftAndRight(1, 3);
        FULL.right.setLeftAndRight(6, 9);
    }
}
