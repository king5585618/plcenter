package com.kakarot.plcenter.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test6 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","S","D","F");
        String s = list.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }
}
