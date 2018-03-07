package Array;
import java.util.*;
/**
 * Created by JMYE on 4/23/16.
 */
public class JoinStringArray {

    public static void main(String args[]){
            String a[] = {"a", "b", "c"};
            String b[] = {"d", "e" };

            List<String> list = new ArrayList<String>(Arrays.asList(a));
            list.addAll(Arrays.asList(b));
            Object [] c = list.toArray();
            System.out.println(Arrays.toString(c));
    /*
     output :  [a, b, c, d, e]
    */
        }
}



/*
public class CollectionUtils {
  private CollectionUtils () {}

  public static String[] join(String [] ... parms) {
    // calculate size of target array
    int size = 0;
    for (String[] array : parms) {
      size += array.length;
    }

    String[] result = new String[size];

    int j = 0;
    for (String[] array : parms) {
      for (String s : array) {
        result[j++] = s;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String a[] = { "1", "2", "3" };
    String b[] = { "4", "5", "6" };
    String c[] = { "7", "8", "9" };

    String[] big = (String [])join(a,b,c);
    System.out.println(java.util.Arrays.toString(big));

}

**/

