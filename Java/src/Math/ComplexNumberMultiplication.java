package Math;

import java.util.stream.Stream;

/**
 * Created by JMYE on 5/10/17.
 * (a+bi)(c+di) = (ac - bd) + (ad+bc)i
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
                coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();

        return String.format("%d+%di", (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]),
                (coefs1[0]*coefs2[1]+coefs1[1]*coefs2[0]));
    }
}
