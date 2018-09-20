package com.kakarot.plcenter.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test2 {

    public static void main(String[] args) {
        String[] strs = new String[]{"Hello","world"};
        Stream<String> stream = Arrays.stream(strs);
        stream.forEach(System.out::println);
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.stream().map(word->word.split("")).map(Arrays::stream).forEach(System.out::println);

        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");
        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
