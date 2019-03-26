package com.hhx.structure.queue;

import org.junit.Test;

public class ArrayRingQueueTest {

    @Test
    public void test() {
        ArrayRingQueue<String> arrayRingQueue = new ArrayRingQueue<>(4);
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.enqueue("a"));
        System.out.println(arrayRingQueue.enqueue("b"));
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.enqueue("c"));
        System.out.println(arrayRingQueue.enqueue("d"));
        System.out.println(arrayRingQueue.enqueue("e"));
        System.out.println(arrayRingQueue.enqueue("f"));
        System.out.println(arrayRingQueue.enqueue("g"));
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.enqueue("h"));
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.dequeue());
        System.out.println(arrayRingQueue.dequeue());
    }
}