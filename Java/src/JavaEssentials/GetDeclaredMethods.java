package JavaEssentials;

import Backtracking.CountNumberswithUniqueDigits;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JMYE on 3/15/17.
 */
public class GetDeclaredMethods {
    public static void main(String[] args) {
        Class test = CountNumberswithUniqueDigits.class;
        Method[] methods = test.getDeclaredMethods();

        ArrayList<String> methodNames = new ArrayList<>();
        for (Method m : methods) {
            methodNames.add(m.getName());
        }
        Collections.sort(methodNames);
        for (String name : methodNames) {
            System.out.println(name);
        }
    }
}
