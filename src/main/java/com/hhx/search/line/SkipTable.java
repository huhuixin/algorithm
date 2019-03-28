package com.hhx.search.line;

import com.hhx.search.AbstractSearch;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * 跳表
 *
 *  通过一个单链表 添加多级索引来 实现
 *
 * @author hhx
 */
public class SkipTable<E> extends AbstractSearch<E> {

    private LinkedList<E> list;

    public SkipTable(Comparator<E> comparator, Function<E, String> showType) {
        super(comparator, showType);
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }
}
