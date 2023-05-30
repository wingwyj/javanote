package jdk.java8.lambda;

import jdk.java8.functioninterface.MyFunctionInterface;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/3/12
 */
public class LambdaTest {
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface = Integer::sum;

        int action = myFunctionInterface.action(2, 4);
        System.out.println(action);
    }

    public static void test(MyFunctionInterface func){


    }
}
