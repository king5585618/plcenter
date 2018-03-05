package com.kakarot.plcenter.assist;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class ClassPoolDemo {

    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass("java.lang.String");
        System.out.println(ctClass.getName());
        System.out.println(ctClass.getAnnotations());
        System.out.println(ctClass.getClassPool());
    }
}
