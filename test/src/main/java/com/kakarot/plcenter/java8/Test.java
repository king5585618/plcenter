package com.kakarot.plcenter.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    public static List<Apple> filterApples(List<Apple> list, Predicate<Apple> p){
//        List<Apple> newList = new ArrayList<>();
//        for(Apple apple: list) {
//            if(p.test(apple)){
//                newList.add(apple);
//            }
//        }
        return list.stream().filter(apple->p.test(apple)).collect(Collectors.toList());
//        return newList;
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setColor("green");
        apple1.setWeight(100);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(200);
        Apple apple3 = new Apple();
        apple3.setColor("yellow");
        apple3.setWeight(100);
        Apple apple4 = new Apple();
        apple4.setColor("yellow");
        apple4.setWeight(200);
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        list.add(apple4);
        List<Apple> newList = filterApples(list,AppleUtil::isGreen);
        for(Apple apple: newList){
            System.out.println(apple.getColor()+":"+apple.getWeight());
        }

        filterApples(list, apple -> apple.getWeight()>150).stream().forEach(r-> System.out.println(r.getColor()+":"+r.getWeight()));
    }
}
