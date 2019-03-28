package com.hhx.search;

import com.hhx.entity.User;
import com.hhx.search.line.HashList;
import com.hhx.util.RandomUtil;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hhx.Constant.*;

public class HashListTest {

    private static Supplier<User> randomSupplier = () ->
            new User().setAge(RandomUtil.randomInt(0, 100))
                    .setName(RandomUtil.randomLetterString(1).toLowerCase());

    Function<User, Integer> hashAge = User::getAge;

    Function<User, Integer> hashNameByFirstChar = u -> u.getName().charAt(0) - 'a';

    Function<User, Integer> hashName = u -> u.getName().hashCode();

    AbstractSearch<User> ageSearch = new HashList<>(compareByAgeAsc, hashAge, showAge);
    AbstractSearch<User> nameSearch = new HashList<>(compareByNameAsc, hashNameByFirstChar, showName, 2);

    @Test
    public void add() {
        List<User> collect = Stream.generate(randomSupplier).limit(8).collect(Collectors.toList());
        System.out.println(collect.stream().map(showAge).collect(Collectors.joining(",")));
        nameSearch.addAll(collect.stream());
    }

    @Test
    public void remove() {
        // 此时 hashNameByFirstChar 是一个不合理的算法,因为当散列表长度超过26时,后面的空间就是浪费的, 而且这明显是一个
        // 不合理的hash算法, 因为用户的名字有一定规律, 在散列表中的分布是不均匀的
        List<User> collect = Stream.generate(randomSupplier).limit(20).collect(Collectors.toList());
        System.out.println(collect.stream().map(showName).collect(Collectors.joining(",")));
        nameSearch.addAll(collect.stream());
        for (int i = 0; i < 26; i++) {
            char name = (char)('a' + i);
            nameSearch.remove(new User().setName(name + ""));
        }
    }

    @Test
    public void contains() {
        AbstractSearch<User> search = new HashList<>(compareAgeAndName, hashNameByFirstChar, showFull);
        List<User> collect = Stream.generate(randomSupplier).limit(20).collect(Collectors.toList());
        System.out.println(collect.stream().map(showFull).collect(Collectors.joining(",")));
        search.addAll(collect.stream());
        User target = new User().setAge(1).setName("h");
        System.out.print("search:" + target + " : ");
        System.out.println(search.contains(target));
    }
}