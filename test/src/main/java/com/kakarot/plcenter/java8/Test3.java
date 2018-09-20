package com.kakarot.plcenter.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1,100).sum());
        System.out.println(IntStream.range(1,100).sum());
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        ).limit(5);
        pythagoreanTriples.forEach(t-> System.out.println(t[0]+":"+t[1]+":"+t[2]));
        Stream.iterate(0, n->n+2).limit(10).forEach(System.out::println);
    }
}
