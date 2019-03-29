package com.hhx.search.tree;

import com.hhx.search.AbstractSearch;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 二叉树
 *
 * @author hhx
 */
public abstract class BinaryTree<E> extends AbstractSearch<E> {
    public BinaryTree(Comparator<E> comparator, Function<E, String> showType) {
        super(comparator, showType);
    }
}
