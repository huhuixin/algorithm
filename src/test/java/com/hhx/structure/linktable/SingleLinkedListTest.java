package com.hhx.structure.linktable;

import org.junit.Test;

public class SingleLinkedListTest {

    @Test
    public void testLinkTable(){
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("bbb");
        list.addLast("ccc");
        list.addFirst("eee");

        list.removeFirst();
        list.removeLast();
        list.remove("aaa");
    }

    @Test
    public void testRemoveLast(){
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("bbb");
        list.addFirst("ccc");
        list.removeLast();
        list.removeLast();
        list.removeLast();
    }

    @Test
    public void reverse() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addFirst("aaa");
        list.addFirst("bbb");
        list.addFirst("ccc");
        list.addFirst("ddd");
        System.out.println(list);
        System.out.println("--- reverse ---");
        list.reverse();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println("--- reverse ---");
        list.reverse();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println("--- reverse ---");
        list.reverse();
        System.out.println(list);
    }
}