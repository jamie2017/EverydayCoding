package String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by JMYE on 3/14/17.
 */
public class StringToken {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.trim().length() == 0) {
            System.out.println(0);
        } else {
            String[] tokens = s.trim().split("[ !,?._'@]+");
            System.out.println(tokens.length);
//            Arrays.stream(tokens).forEach(System.out::println);
        }

    }




}
