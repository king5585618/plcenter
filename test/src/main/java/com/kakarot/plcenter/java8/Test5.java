package com.kakarot.plcenter.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test5 {

    public static Integer test(Integer i){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        Long begin = System.currentTimeMillis();
        list.stream().forEach(Test5::test);
        Long end = System.currentTimeMillis();
        System.out.println(end-begin);

        Long begin2 = System.currentTimeMillis();
        list.parallelStream().forEach(Test5::test);
        Long end2 = System.currentTimeMillis();
        System.out.println(end2-begin2);

//        list.stream().reduce(()->1).get();

        List<CompletableFuture<Integer>> list1 = list.stream().map(t->CompletableFuture.supplyAsync(()->test(t))).collect(Collectors.toList());

    }
}
