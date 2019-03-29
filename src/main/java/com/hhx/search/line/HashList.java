package com.hhx.search.line;

import com.hhx.search.AbstractSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * 散列表
 * // TODO 一致性hash算法
 * @author hhx
 */
public class HashList<E> extends AbstractSearch<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 3;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 默认加载因子, 当元素数量/容器长度时, 自动扩容
     */
    private float loadFactor;
    /**
     * 数组长度
     */
    private int length = DEFAULT_INITIAL_CAPACITY;
    /**
     * 元素数量
     */
    private int size = 0;
    /**
     * 元素放在链表中
     */
    private LinkedList<E>[] data = new LinkedList[DEFAULT_INITIAL_CAPACITY];

    private Function<E, Integer> hashCode;

    public HashList(Comparator<E> comparator, Function<E, Integer> hashCode, Function<E, String> showType) {
        this(comparator, hashCode, showType, DEFAULT_LOAD_FACTOR);
    }

    public HashList(Comparator<E> comparator, Function<E, Integer> hashCode, Function<E, String> showType, float loadFactor) {
        super(comparator, showType);
        this.hashCode = hashCode;
        this.loadFactor = loadFactor;
    }

    private int getHash(E e){
        return hashCode.apply(e) % length;
    }

    @Override
    public boolean add(E e) {
        size++;
        rehash();
        int hash = getHash(e);
        LinkedList<E> node = data[hash];
        if(node == null){
            node = data[hash] = new LinkedList<>();
        }
        node.add(e);
        System.out.println(toString());
        return true;
    }

    private void rehash() {
        if((float)size/length > loadFactor){
            // 数量已经占据到了一定百分比 变2倍
            length <<= 1;
        }else if(length > DEFAULT_INITIAL_CAPACITY && size < length >> 2){
            // 缩容, 数据经过了一次以上的扩容且容器内空间利用率不足1/4
            length >>= 1;
        }else{
            return;
        }
        LinkedList<E>[] oldData = data;
        data = new LinkedList[length];
        // 迁移数据
        for (LinkedList<E> oldDatum : oldData) {
            if(oldDatum != null && !oldDatum.isEmpty()){
                oldDatum.forEach(e -> {
                    int hash = getHash(e);
                    LinkedList<E> node = data[hash];
                    if(node == null){
                        node = data[hash] = new LinkedList<>();
                    }
                    node.add(e);
                });
            }
        }
    }

    @Override
    public boolean remove(E e) {
        int hash = getHash(e);
        LinkedList<E> node = data[hash];
        if(node == null){
            return false;
        }
        Iterator<E> iterator = node.iterator();
        boolean removed =  false;
        while(iterator.hasNext()){
            E next = iterator.next();
            if(comparator.eq(e, next)){
                iterator.remove();
                removed = true;
                size --;
                System.out.println(toString());
            }
        }
        rehash();
        return removed;
    }

    @Override
    public boolean contains(E e) {
        int hash = getHash(e);
        LinkedList<E> node = data[hash];
        if(node == null){
            return false;
        }
        return node.stream().anyMatch(item -> comparator.eq(item, e));
    }

    @Override
    public String toString() {
        // 找到最大的树高
        int max = Arrays.stream(data).mapToInt(node -> node == null ? 0 : node.size()).max().orElse(0);
        StringBuilder sb = new StringBuilder(length * (4 + max * 2));
        // head
        for (int i = 0; i < length; i++) {
            sb.append(i).append("\t");
        }
        sb.append("\n");
        for (int i = 0; i < length; i++) {
            sb.append("-\t");
        }
        sb.append("\n");
        // body
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < length; j++) {
                LinkedList<E> datum = data[j];
                if(datum != null && datum.size() > i){
                    E e = datum.get(i);
                    if(e != null){
                        sb.append(showType.apply(e)).append("\t");
                    }else{
                        sb.append("\t");
                    }
                }else{
                    sb.append("\t");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
