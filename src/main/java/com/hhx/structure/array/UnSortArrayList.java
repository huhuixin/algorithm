package com.hhx.structure.array;

/**
 * 数组
 *
 * 内存连续
 *
 * 优点: 支持随机访问(目标内存地址 = base_address + index * size), 时间复杂度O(1)
 *      内存连续, 支持CPU缓存
 *
 * 缺点: 大小固定
 *
 *
 * @author hhx
 */
public class UnSortArrayList<E> extends AbstractArrayList<E> {

    public UnSortArrayList() {
        super(16);
    }

    public UnSortArrayList(int capacity) {
        super(capacity);
    }

    public boolean add(E e) {
        // 扩容2倍
        newSize(length + 1);
        array[length++] = e;
        return true;
    }

    private void newSize(int newSize){
        if(newSize > array.length){
            // 扩容
            changeSize(array.length * 2);
        }else if(newSize < array.length/4 && newSize > capacity){
            // 长度是现有的4倍以上, 且大于初始长度, 缩容到1/2
            changeSize(array.length / 2);
        }
    }

    private void changeSize(int length){
        System.out.println("length: " + this.length);
        System.out.println("old array length: " + array.length);
        Object[] dest = new Object[length];
        System.arraycopy(array, 0, dest, 0, this.length);
        array = dest;
        System.out.println("newSize: " + array.length);
    }

    public boolean remove(E o) {
        int index = indexOf(o);
        // 保证内存连续性, 不保证顺序, 移除之后选择最后一个元素补进来
        if(index > -1){
            newSize(--length);
            array[index] = array[length];
            array[length] = null;
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < length; i++) {
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }
}
