package com.hhx.sort;

import com.hhx.sort.factory.CustomArrayFactory;
import lombok.Getter;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 排序工具
 *
 * @author hhx
 */
public abstract class AbstractSort<E> {

    /**
     * 待排序数据
     */
    protected E[] array;

    protected int length;

    protected ComparatorUtil<E> comparator;

    protected Function<E, String> showType;

    @Getter
    protected long swapCount = 0;

    @Getter
    protected long moveCount = 0;

    private IArrayFactory<E> factory;

    public AbstractSort(E[] array, Comparator<E> comparator) {
        this.factory = new CustomArrayFactory<>(array);
        this.array = array;
        this.length = array.length;
        this.comparator = new ComparatorUtil<>(comparator);
    }

    public AbstractSort(IArrayFactory<E> factory, Comparator<E> comparator) {
        this.factory = factory;
        this.array = factory.getArray();
        this.length = array.length;
        this.comparator = new ComparatorUtil<>(comparator);
    }

    public AbstractSort(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        this.array = factory.getArray();
        this.length = array.length;
        this.comparator = new ComparatorUtil<>(comparator);
        this.showType = showType;
    }

    /**
     * 排序
     */
    public abstract void sort();

    /**
     * 是否排序完成
     * @return
     */
    public boolean isFinished(){
        for (int i = 1; i < length; i++) {
            if(comparator.lt(array[i], array[i - 1])){
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j){
        swapCount ++;
        Arrays.swap(array, i, j);
    }

    /**
     * 把下标i的值移动到j , j的值被覆盖
     * @param i
     * @param j
     */
    public void move(int i, int j) {
        moveCount ++;
        array[j] = array[i];
    }

    public long watchSort(){
        showStatus();
        System.out.println("sort start ... ");
        long t1 = System.nanoTime();
        sort();
        System.out.println("sort end ... ");
        return System.nanoTime() - t1;
    }

    public long watchSort(int time){
        System.out.print("start sort ... ");
        long t1 = System.nanoTime();
        for (int i = 0; i < time; i++) {
            array = factory.getArray();
            sort();
        }
        return System.nanoTime() - t1;
    }

    public long getCompareCount(){
        return comparator.getCount();
    }

    /**
     * 输出
     */
    public String showStatus(Function<E, String> function){
        return Arrays.toString(array, function);
    }

    public void showStatus(){
        if(showType != null){
            System.out.println("status: " + showStatus(showType));
        }
    }

    public String getStatus(E k) {
        if(showType != null){
            return showType.apply(k);
        }
        return k.toString();
    }

    @Override
    public String toString() {
        return showStatus(showType);
    }
}
