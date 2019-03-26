package com.hhx.structure.linktable;

import com.hhx.structure.Collection;

/**
 * 单链表
 *
 * @author hhx
 */
public abstract class AbstractLinkedList<E> implements Collection<E> {

    protected int length;

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean addFirst(E e);

    public abstract boolean addLast(E e);

    public abstract boolean removeFirst();

    public abstract boolean removeLast();

    public abstract E getFirst();

    public abstract E getLast();

    public abstract void reverse();
}
