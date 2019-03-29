package com.hhx.search.tree;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 简单二叉树
 *
 * 左右节点连接两个
 *
 * @author hhx
 */
public class SimpleBinaryTree<E> extends BinaryTree<E> {

    public SimpleBinaryTree(Comparator<E> comparator, Function<E, String> showType) {
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
