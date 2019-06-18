package com.nqlz.thread_demo.throwable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

/**
 * 功能描述:
 *
 * @author: MR.zt
 * @date: 2019/6/18 15:19
 */
public class ErrorAndException {

    public static int doWork(){
        try {
            int i = 10/0;
            System.out.println("i:"+i);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException异常处理");
            return 22;
        }catch (Exception e){
            System.out.println("Exception异常");
        }finally {
            System.out.println("finally");
            return 99;
        }
    }

    private void throwError(){
        throw  new StackOverflowError();
    }

    private void throwRuntimeException(){
        throw new RuntimeException();
    }

    private void throwCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }


    public static void main(String[] args) {
        ErrorAndException errorAndException = new ErrorAndException();
        Logger logger = LoggerFactory.getLogger(ErrorAndException.class);
        /*try {
            errorAndException.throwCheckedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        errorAndException.throwError();
        errorAndException.throwRuntimeException();*/
        System.out.println( doWork());;
    }

}
