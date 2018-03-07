package String;

/**
 * Created by JMYE on 9/24/16.
 */
import java.util.Arrays;
class toString {
    public static void main(String[] args){
        char[] letterChar = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println("Using Arrays.toString(letterChar) : " + Arrays.toString(letterChar));
        System.out.println("Using new String(letterChar) : " + new String(letterChar));
        System.out.println("Using String.valueOf(letterChar : " + String.valueOf(letterChar));
        System.out.println("Using letterChar.toString() : " + letterChar.toString());

    }
}