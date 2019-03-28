package com.hhx.structure.stack;

import java.util.LinkedList;

/**
 * @author hhx
 */
public class LinkedStack<E> {

    private LinkedList<E> list = new LinkedList<E>();

    /** 入栈 */
     public void push(E e){
        list.addFirst(e);
    }

    /** 查看栈顶元素但不移除 */
    public E peek(){
        return list.getFirst();
    }

    /** 出栈 */
    public E pop(){
        return list.removeFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
