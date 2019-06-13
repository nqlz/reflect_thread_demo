package com.nqlz.thread_demo.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/12 22:19
 */
public class ClassUtils {


    /**
     * 成员函数
     *
     * @param object
     */
    public static void printClassMethodMessage(Object object) throws Exception {
        Class<?> aClass = object.getClass();
        System.out.println("类的名称：" + aClass.getName());

        /**
         *  方法
         */

        /*
        所有方法，包括继承而来的
         */
        Method[] methods = aClass.getMethods();

        /*
        自己定义的方法
         */
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        //打印方法名
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            //获取返回值类型的类类型
            Class<?> returnType = method.getReturnType();
            //打印返回值类型名称
            System.out.println("返回值名称：" + returnType.getName());

            System.out.print("方法名：" + method.getName() + "  (");
            //获取参数类型的类类型，
            Class<?>[] parameterTypes = method.getParameterTypes();

            for (Class param : parameterTypes) {
                System.out.print("参数名：" + param.getName());
            }
            System.out.print("  )");
            System.out.println();

        }

    }


    /**
     * 成员变量
     */
    public static void printClassFields(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //成员变量的类类型
            Class<?> type = field.getType();
            System.out.print("成员变量类型名称：" + type.getName());
            System.out.print("----成员变量名称" + field.getName());
            System.out.println();
        }
    }

    /**
     * 构造方法
     * @param object
     */
    public static void constructMessage(Object object){
        Class<?> aClass = object.getClass();

        Constructor<?>[] constructors = aClass.getConstructors();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        for (Constructor cs:declaredConstructors){
            System.out.print("构造方法："+cs.getName()+"(");
            //获取构造函数参数
            Class[] parameterTypes = cs.getParameterTypes();

            for (Class param : parameterTypes) {
                System.out.print("构造参数类型名：" + param.getName()+",");
            }
            System.out.println(")");
        }


    }

}
