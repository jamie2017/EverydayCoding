package JavaEssentials;

import java.lang.reflect.Method;

/**
 * Created by JMYE on 3/15/17.
 */

/*
Generic methods are a very efficient way to handle multiple datatypes using a single method.
This problem will test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array.
You have to write a single method printArray that can print all the elements of both arrays.
The method should be able to accept both integer arrays or string arrays.

 */
public class JavaGenerics {
    public <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
    public static void main( String args[] ) {
        JavaGenerics myPrinter = new JavaGenerics();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
//        int count = 0;
//
//        for (Method method : JavaGenerics.class.getDeclaredMethods()) {
//            String name = method.getName();
//
//            if(name.equals("printArray"))
//                count++;
//        }
//
//        if(count > 1)System.out.println("Method overloading is not allowed!");

    }

}
