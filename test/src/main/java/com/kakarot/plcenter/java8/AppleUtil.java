package com.kakarot.plcenter.java8;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class AppleUtil {

    public static boolean isGreen(Apple apple){
        if("green".equals(apple.getColor())){
            return true;
        }
        return false;
    }
}
