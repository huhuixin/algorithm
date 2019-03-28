package com.hhx.search;

import com.hhx.entity.User;
import com.hhx.search.line.Binary;
import com.hhx.util.IArrayFactory;
import com.hhx.util.RandomUtil;
import com.hhx.util.factory.RandomArrayFactory;
import org.junit.Test;

import java.util.function.Supplier;

import static com.hhx.Constant.*;

/**
 * @author hhx
 */
public class BinaryTest {

    private static Supplier<User> randomSupplier = () ->
            new User().setAge(RandomUtil.randomInt(0, 4))
                    .setName(RandomUtil.randomLetterString(1).toLowerCase());

    private static IArrayFactory<User> randomArrayFactory =
            new RandomArrayFactory<>(randomSupplier, 8);

    private static User target = new User().setAge(1).setName("h");

    @Test
    public void binarySearchTest(){
        Binary<User> search = new Binary<>(randomArrayFactory, compareByAgeAsc, showAge);
        //search = new Binary<>(randomArrayFactory, compareByNameAsc, showName);
        System.out.println(search.toString());
        System.out.println("contains: " + search.contains(target));
        System.out.println("first: " + search.firstIndexOf(target));
        System.out.println("last: " + search.lastIndexOf(target));
        System.out.println("compare count: " + search.getCompareCount());
    }

    @Test
    public void binaryAddAndRemoveTest(){
        Binary<User> search = new Binary<>(randomArrayFactory, compareByAgeAsc, showFull);
        System.out.println(search.toString());
        search.add(new User().setAge(1).setName("1"));
        System.out.println(search.toString());
        search.add(new User().setAge(2).setName("2"));
        System.out.println(search.toString());
        search.add(new User().setAge(3).setName("3"));
        System.out.println(search.toString());
        search.add(new User().setAge(4).setName("4"));
        System.out.println(search.toString());
        search.add(new User().setAge(-1).setName("-1"));
        System.out.println(search.toString());

        search.remove(new User().setAge(1));
        System.out.println(search.toString());
        search.remove(new User().setAge(2));
        System.out.println(search.toString());
        search.remove(new User().setAge(3));
        System.out.println(search.toString());
        search.remove(new User().setAge(4));
        System.out.println(search.toString());
        search.remove(new User().setAge(-1));
        System.out.println(search.toString());
        search.remove(new User().setAge(-2));
        System.out.println(search.toString());
        search.remove(new User().setAge(5));
        System.out.println(search.toString());
    }
}