package com.kakarot.plcenter.invocation;

/**
 * @author jinzj
 * @since v4.0.0
 */
public interface IMath {

    //加
    int add(int n1, int n2);

    //减
    int sub(int n1, int n2);

    //乘
    int mut(int n1, int n2);

    //除
    int div(int n1, int n2);
}
