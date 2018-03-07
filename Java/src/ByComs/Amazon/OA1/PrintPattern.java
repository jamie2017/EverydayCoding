package ByComs.Amazon.OA1;

public class PrintPattern {
    public static void printPattern(int row) {
//        char ch = 'a';
        for (int i = 0; i < row; i++) {
            char ch = 'a';
            char toPrint = ch;
            for(int j = 0; j <= i; j++) {
                System.out.print(toPrint++);
            }
            System.out.println("");
        }
    }
    public static void printPattern2(int row) {
        int x = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(x + "" + x);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        printPattern(4);
        printPattern2(3);
    }
}
