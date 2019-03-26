package com.hhx.structure.queue;

import com.hhx.structure.Collection;

/**
 * 数组实现环形队列
 *
 * @author hhx
 */
public class ArrayRingQueue<E> implements Collection<E> {

    private Object[] array;
    private int head = 0;
    private int tail = 0;
    private int length;

    public ArrayRingQueue(int capacity) {
        array = new Object[capacity + 1];
        length = capacity + 1;
    }

    public boolean isFull(){
        return (tail + 1) % length == head;
    }

    @Override
    public int size() {
        return length - Math.abs(tail - head);
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean add(E e) {
        if (!isFull()){
            array[tail] = e;
            tail = (tail + 1) % length;
            return true;
        }
        return false;
    }

    public boolean enqueue(E e){
        return add(e);
    }

    public E dequeue(){
        if (!isEmpty()){
            E e = ((E) array[head]);
            array[head] = null;
            head = (head + 1) % length;
            return e;
        }
        return null;
    }

    @Override
    public boolean remove(E e) {
        if (!isEmpty()){
            array[head] = null;
            head = (head + 1) % length;
            return true;
        }
        return false;
    }
}
