package com.kakarot.plcenter.feibo;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    public static int test3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return test3(n-1) + test3(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(Test.test3(10));
    }
}
