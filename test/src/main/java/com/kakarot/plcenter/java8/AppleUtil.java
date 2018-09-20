package com.kakarot.plcenter.java8;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class AppleUtil {

    public static boolean isGreen(Apple apple){
        String s = "green";
        //noinspection AlibabaUndefineMagicConstant
        if(s.equals(apple.getColor())){
            return true;
        }
        return false;
    }
}
