package com.hhx.structure.queue;

/**
 * 数组实现环形队列
 *
 * @author hhx
 */
public class ArrayRingQueue<E> {

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

    public int size() {
        return length - Math.abs(tail - head);
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean enqueue(E e){
        if (!isFull()){
            array[tail] = e;
            tail = (tail + 1) % length;
            return true;
        }
        return false;
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
}
