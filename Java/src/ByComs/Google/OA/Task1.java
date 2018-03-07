package ByComs.Google.OA;

/**
 * Created by JMYE on 11/1/16.
 */
public class Task1 {
    public static int returnMax(int x) {
        if (x < 10) return x;
        String xString = String.valueOf(x);

        int globalMax = Integer.MIN_VALUE;
        int roundUp;
        int left = 0, right = 0, window = 0;
        while(right < xString.length()) {
            window += xString.charAt(right) - '0';
            right++;
            if (right - left == 2) {
                if (window % 2 == 0) {
                    roundUp = window / 2;
                } else {
                    roundUp = (window + 1) / 2;
                }
                String tmp = xString.substring(0,left) + roundUp + "" + xString.substring(right);
                globalMax = Math.max(globalMax,Integer.parseInt(tmp));
                window = window - (xString.charAt(left) - '0');
                left ++;
            }
        }
        return globalMax;
    }


    public static int returnMax2(int x) {
        if (x < 10) return x;
        String xStr = String.valueOf(x);
        int globalMax = Integer.MIN_VALUE;
        int first, second, curNum, roundUp, curMax;
        for (int i = 0; i < xStr.length() - 1; i++) {
            first = xStr.charAt(i) - '0';
            second = xStr.charAt(i + 1) - '0';
            curNum = first + second;
            if (curNum % 2 == 0) {
                roundUp = curNum / 2;
            } else {
                roundUp = (curNum + 1) / 2;
            }
            String curStr = xStr.substring(0, i) + String.valueOf(roundUp) + xStr.substring(i + 2);
            curMax = Integer.parseInt(curStr);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }


    public static int returnMin(int x) {
        if (x < 10) return x;
        String xString = Integer.toString(x);

        int rst = Integer.MAX_VALUE;
        int newDigit;
        int left = 0, right = 0;
        while(right < xString.length()) {
            right++;
            if (right - left == 2) {
                int first = xString.charAt(left) - '0';
                int second = xString.charAt(left + 1) - '0';
                newDigit = Math.max(first, second);
                String tmp = xString.substring(0,left) + newDigit + "" + xString.substring(right);
                rst = Math.min(rst,Integer.parseInt(tmp));
                left ++;
            }
        }
        return rst;
    }

    public static int returnMin2 (int x) {
        if (x < 10) return x;
        int globalMin = Integer.MAX_VALUE;
        String str = String.valueOf(x);

        for (int i = 0; i < str.length() - 1; i++)
        {
            int first = str.charAt(i) - '0';
            int second = str.charAt(i+1) - '0';
            int curMax = Math.max(first, second);
            String curStr = str.substring(0, i) + String.valueOf(curMax) + str.substring(i+2);
            int curNum = Integer.parseInt(curStr);
            globalMin = Math.min(globalMin, curNum);
        }

        return globalMin;
    }

    public static int returnGroupMax(int x) {
        if (x < 10) return 0;
        String xString = Integer.toString(x);
        int rst = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while(right < xString.length()) {
            right++;
            if (right - left == 1 && right < xString.length()) {
                if (xString.charAt(right) == xString.charAt(left)) {
                    String tmp = xString.substring(0,left) + xString.substring(right);
                    rst = Math.max(rst,Integer.parseInt(tmp));
                }
                left ++;
            }
        }
        return rst;
    }

    public static int returnGroupMax2(int x) {
        if (x < 10) return x;
        int globalMax = Integer.MIN_VALUE;
        String str = String.valueOf(x);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                String curStr = str.substring(0, i) + str.substring(i + 1);
                int curNum = Integer.parseInt(curStr);
                globalMax = Math.max(globalMax, curNum);
            }
        }
        return globalMax;
    }
    public static void main(String[] args) {
        int x1 = 623315;
        System.out.println(returnMax(x1));
        System.out.println(returnMax2(x1));

        int x2 = 233614;
        System.out.println(returnMin(x2));
        System.out.println(returnMin2(x2));

        int x3 = 223336226;
        System.out.println(returnGroupMax(x3));
        System.out.println(returnGroupMax2(x3));
    }

}
