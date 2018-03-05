package com.kakarot.plcenter.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class MethodTypeSpy {

    private static final String fmt = "%24s:   %s\n";
    private static final String HELLO_WORLD = "I'm cute shixin";

    public static void main(String[] args) throws ClassNotFoundException {
        MethodTypeSpy methodTypeSpy = new MethodTypeSpy();
        Class<? extends MethodTypeSpy> cls = methodTypeSpy.getClass();
        System.out.println("Class："+ cls.getCanonicalName());
        System.out.println(cls.getName());
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("Method name:"+declaredMethod.getName());  //获得单独的方法名
            //获得完整的方法信息（包括修饰符、返回值、路径、名称、参数、抛出值）
            System.out.println("toGenericString:"+declaredMethod.toGenericString());

            int modifiers = declaredMethod.getModifiers();      //获得修饰符
            System.out.println("Modifiers:"+ Modifier.toString(modifiers));

            System.out.format(fmt, "ReturnType", declaredMethod.getReturnType());   //获得返回值
            System.out.format(fmt, "getGenericReturnType", declaredMethod.getGenericReturnType());//获得完整信息的返回值

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes(); //获得参数类型
            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.format(fmt, "ParameterType", parameterTypes[i]);
                System.out.format(fmt, "GenericParameterType", genericParameterTypes[i]);
            }

            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();     //获得异常名称
            Type[] genericExceptionTypes = declaredMethod.getGenericExceptionTypes();
            for (int i = 0; i < exceptionTypes.length; i++) {
                System.out.format(fmt, "ExceptionTypes", exceptionTypes[i]);
                System.out.format(fmt, "GenericExceptionTypes", genericExceptionTypes[i]);
            }

            Annotation[] annotations = declaredMethod.getAnnotations(); //获得注解
            for (Annotation annotation : annotations) {
                System.out.format(fmt, "Annotation", annotation);
                System.out.format(fmt, "AnnotationType", annotation.annotationType());
            }
        }
    }
}
