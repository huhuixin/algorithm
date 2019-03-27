package com.hhx.structure.linktable;

/**
 * 单链表
 *
 * @author hhx
 */
public class SingleLinkedList<E> {

    private Node<E> head;
    private Node<E> last;

    protected int length;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        private Node(E item) {
            this.item = item;
        }
    }

    public boolean addFirst(E e){
        if(head == null){
            head = new Node<>(e);
        } else {
            Node temp = new Node<>(e);
            temp.next = head;
            head = temp;
        }
        length ++;
        return true;
    }

    public boolean addLast(E e){
        if(head == null){
            head = new Node<>(e);
            last = head;
        } else {
            last.next = new Node<>(e);
            last = last.next;
        }
        length++;
        return true;
    }

    public boolean removeFirst(){
        if(head == null){
            return false;
        }
        head = head.next;
        return true;
    }

    public boolean removeLast(){
        if(head == null){
            return false;
        }
        Node prev = head;
        Node temp = head.next;
        if(temp == null){
            head = null;
            return true;
        }
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        last = prev;
        length --;
        return true;
    }

    public E getFirst(){
        if(head != null){
            return head.item;
        }
        return null;
    }

    public E getLast(){
        if(last != null){
            return last.item;
        }
        return null;
    }

    public boolean remove(E e) {
        if(head == null){
            return false;
        } else {
            Node temp = head.next;
            Node prev = head;
            while(temp != null){
                if(temp.item.equals(e)){
                    if(temp.next == null){
                        // 最后一个节点
                        prev.next = null;
                    }else{
                        prev.next = temp.next;
                    }
                    length--;
                }
                temp = temp.next;
            }
        }
        return true;
    }

    public boolean contains(E e) {
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.item.equals(e)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(Node<E> node){
        if(node == null){
            return "";
        }
        return node.item.toString() + " -> " + toString(node.next);
    }

    /**
     * 反转单链表
     * 思路, 将当前元素的下一个元素编程头结点
     *             1, 2, 3, 4, 5
     *          2, 1, 3, 4, 5
     *       3, 2, 1, 4, 5
     *    4, 3, 2, 1, 5
     * 5, 4, 3, 2, 1
     */
    public void reverse(){
        if(length < 2){
            return;
        }
        Node cur = head;
        while(cur.next != null){
            Node temp = cur.next;
            cur.next = temp.next;
            temp.next = head;
            head = temp;
        }
        last = cur;
    }
}
