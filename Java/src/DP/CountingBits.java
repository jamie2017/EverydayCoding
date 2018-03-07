package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class CountingBits {
    public int[] countBits(int num) {
        /*

        f[i] = f[i/2] + i % 2
        let f[i] be the count of 1 bit at i,
        for example f[i] = x
        then if i is odd, then f[i>>1] = x -1 = f[i] - 1
             if i is even, then f[i>>1] = f[i]
        where if i is odd, i & 1 = 1
              if i is even i & 1 = 0
        thus we have
        f[i] = f[i >> 1] + (i & 1) .
        This is more straight-forward. Right shit by 1 bit,
        compare to previously,
        the number of set bit would either reduce by 1(when number is odd) or no change(when number is even),
        that is why we add ( i & 1 ) which reflects whether the number is even or odd.
         */
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            System.out.print(i+">>1: ");
            System.out.println(i>>1);
            System.out.print(i+"&1: ");
            System.out.println(i & 1);
            System.out.println();
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }

    public int[] countBits2(int num) {
        int[] answer = new int[num+1];
        int offset = 1;
        for(int i = 1; i < answer.length; i++){
            if(offset * 2 == i) offset *= 2;
            answer[i] = 1 + answer[i - offset];
        }
        return answer;
    }

    public static void main(String[] argu) {
        CountingBits test = new CountingBits();
        test.countBits(5);
    }
}
