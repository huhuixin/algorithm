package com.hhx.sort.method;

import com.hhx.sort.AbstractSort;
import com.hhx.util.IArrayFactory;

import java.util.Comparator;
import java.util.function.Function;

/**
 * 归并排序
 *
 * @author hhx
 */
public class Merge<E> extends AbstractSort<E> {

    private E[] temp;

    public Merge(IArrayFactory<E> factory, Comparator<E> comparator) {
        this(factory, comparator, null);
    }

    public Merge(IArrayFactory<E> factory, Comparator<E> comparator, Function<E, String> showType) {
        super(factory, comparator, showType);
        temp = ((E[]) new Object[array.length]);
    }

    @Override
    public void sort() {
        if(length <= 1){
            return;
        }
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int i, int j){
        if(i >= j){ return; }
        System.out.print("sort : [" + i +  "," + j + "]:  ");showStatus();
        int mid = i + (j - i)/2;
        mergeSort(i, mid);
        mergeSort(mid + 1, j);
        merge(i, mid, mid + 1, j);
        System.out.print("merge [" + i +  "," + j + "] end : ");showStatus();
    }
    private void merge(int i1, int j1, int i2, int j2) {
        int length = j2 - i1 + 1;
        int i = 0;
        int start = i1;
        while(true){
            if(i1 <= j1){
                if(i2 <= j2){
                    if(comparator.le(array[i1], array[i2])){
                        temp[i++] = array[i1++];
                    }else{
                        temp[i++] = array[i2++];
                    }
                }else{
                    temp[i++] = array[i1++];
                }
            }else{
                if(i2 <= j2){
                    temp[i++] = array[i2++];
                }else{
                    break;
                }
            }
        }
        moveCount += length * 2;
        System.arraycopy(temp, 0, array, start, length);
    }
}
