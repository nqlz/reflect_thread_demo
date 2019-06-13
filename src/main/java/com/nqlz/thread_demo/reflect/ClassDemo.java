package com.nqlz.thread_demo.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/12 21:51
 */
public class ClassDemo {


    public static void main(String[] args) throws Exception {

        /**
         * 获取类的类类型
         */
        Person p1 = new Person();
        Class<? extends Person> aClass = p1.getClass();
        Class<Person> personClass = Person.class;

        Class<?> aClass1 = Class.forName("com.nqlz.thread_demo.reflect.Person");

        System.out.println(aClass == aClass1 && personClass == aClass);

        /**
         * 通过类的类类型创建对象
         */
        Person myPerson = aClass.newInstance();
        myPerson.print();

//        System.out.println(myPerson.getClass().getName());
//        System.out.println(myPerson.getClass().getSimpleName());

//        ClassUtils.printClassMethodMessage(myPerson.getClass());
//        ClassUtils.printClassFields(myPerson.getClass());
//        ClassUtils.constructMessage(myPerson);

        Method print = aClass.getDeclaredMethod("print", new Class[]{int.class, String.class});
        print.invoke(aClass.newInstance(),1,"ss");




    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    Person(Integer age){

    }

    void print() {
        System.out.println("类调用了");
    }
    void print(int a,String b) {
        System.out.println("俩个参数打印");
    }

    Integer getInteger(String str){
        return 55;
    }


    private String name;
    Integer age;
}