package com.hhx.structure.linktable;

import org.junit.Test;

public class SingleLinkedListTest {

    @Test
    public void testLinkTable(){
        AbstractLinkedList<String> list = new SingleLinkedList<>();
        list.add("aaa");
        list.addFirst("bbb");
        list.addLast("ccc");
        list.addFirst("eee");

        list.removeFirst();
        list.removeLast();
        list.remove("aaa");
    }

    @Test
    public void testRemoveLast(){
        AbstractLinkedList<String> list = new SingleLinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.removeLast();
        list.removeLast();
        list.removeLast();
    }

    @Test
    public void reverse() {
        AbstractLinkedList<String> list = new SingleLinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
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