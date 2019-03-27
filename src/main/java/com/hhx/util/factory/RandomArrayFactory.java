package com.hhx.util.factory;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 指定数量 随机数组
 *
 * @author hhx
 */
public class RandomArrayFactory<E> extends AbstractArrayFactory<E> {

    private Supplier<E> randomSupplier;

    private int length;

    public RandomArrayFactory(Supplier<E> randomSupplier, int length) {
        this.randomSupplier = randomSupplier;
        this.length = length;
    }

    @Override
    public E[] getArray() {
        System.out.println("generator a new array");
        return (E[]) Stream.generate(randomSupplier).limit(length).toArray();
    }
}
