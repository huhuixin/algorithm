package com.hhx.leetcode.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * N叉树
 *
 * @author hhx
 */
public class Node {

    public int val;

    public List<Node> children;

    @Override
    public String toString() {
        return toString(this);
    }

    private static String toString(Node node){
        if(node == null){
            return "null";
        }else{
            return node.val + " -> [" + node.children + "]";
        }
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node... nodes) {
        this.val = val;
        this.children = Arrays.asList(nodes);
    }

    public Node(int val, int... nodes) {
        this.val = val;
        setChildren(nodes);
    }

    public void setChildren(int... nodes) {
        this.children = Arrays.stream(nodes).mapToObj(Node::new).collect(Collectors.toList());
    }
}
