package com.hhx.search.tree;

import com.hhx.structure.stack.LinkedStack;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 二叉树节点
 * @author hhx
 */
public interface IBinaryNode<E> {

    /**
     * 获取值
     * @return
     */
    E getItem();

    /**
     * 获取左子树
     * @return
     */
    IBinaryNode<E> getLeft();

    /**
     * 获取右子树
     * @return
     */
    IBinaryNode<E> getRight();

    default boolean hasLeft(){
        return getLeft() != null;
    }

    default boolean hasRight(){
        return getRight() != null;
    }

    /**
     * 获取当前节点的树高
     * @return
     */
    default int high(){
        return high(this);
    }

    default int high(IBinaryNode<E> node){
        if(node == null){
            return 0;
        }
        return Math.max(high(node.getLeft()), high(node.getRight())) + 1;
    }

    /**
     * 后续遍历  左 -> 右  -> 本身
     * @return
     */
    default Stream<E> posOrder(){
        Stream.Builder<E> builder = Stream.builder();
        consumerPos(this, builder);
        return builder.build();
    }

    /**
     * 后续
     * @param node
     * @param consumer
     */
    default void consumerPos(IBinaryNode<E> node, Consumer<E> consumer){
        if(node == null){
            return;
        }
        consumerPos(node.getLeft(), consumer);
        consumerPos(node.getRight(), consumer);
        consumer.accept(node.getItem());
    }

    /**
     * 前序遍历  本身 ->  左  ->  右
     * @return
     */
    default Stream<E> preOrder(){
        IBinaryNode<E> node = this;
        Stream.Builder<E> builder = Stream.builder();
        LinkedStack<IBinaryNode<E>> stack = new LinkedStack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                builder.add(node.getItem());
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.getRight();
            }
        }
        return builder.build();
    }

    /**
     * 中序遍历, 左 -> 本身 -> 右
     * @return
     */
    default Stream<E> inOrder(){
        IBinaryNode<E> node = this;
        Stream.Builder<E> builder = Stream.builder();
        LinkedStack<IBinaryNode<E>> stack = new LinkedStack<>();
        // 先把当前节点的左子树全部入栈, 再将最后一个入栈的左子树出栈, 再对这个节点的右子树做相同的操作
        while(node != null || !stack.isEmpty()){
            // 持续入栈左节点
            while(node != null){
                stack.push(node);
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                // 从最左节点开始出栈
                builder.add(node.getItem());
                node = node.getRight();
            }
        }
        return builder.build();
    }
}
