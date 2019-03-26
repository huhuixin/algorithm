package com.hhx.leetcode.util;

/**
 * @author huhuixin
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode of(int... values){
        ListNode head = new ListNode(values[0]);
        ListNode temp = head;
        for (int i = 1; i < values.length; i++) {
            temp.next = new ListNode(values[i]);
            temp = temp.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode node = this;
        while(node.next != null){
            sb.append(" -> ").append(node.next.val);
            node = node.next;
        }
        return sb.toString();
    }
}
