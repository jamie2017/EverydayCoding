package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 8/24/16.
 */
public class FlipGame {

    /*
    s = "++++"


    [
        "--++",
        "+--+",
        "++--"
    ]


     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0; )
            //s.indexOf("++", i + 1) is to find the index of "++"  from s.substring(i+1)
            // use i + 1 for cases like "+++", first "++" i = 0, second "++" is at i + 1 = 1
            result.add(s.substring(0, i) + "--" + s.substring(i+2));
        return result;
    }

    public static void main(String[] args) {
        String s = "+++---+++";
        FlipGame test = new FlipGame();
        System.out.println(test.generatePossibleNextMoves(s));
    }
}
