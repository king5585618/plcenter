package com.kakarot.plcenter.enumList;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test1 {

    public static void main(String[] args) {
        A.up.setName("哈哈哈哈");
        System.out.println(A.up.getName());
        TestService testService = new TestService();
        testService.test(A.up);
    }
}
