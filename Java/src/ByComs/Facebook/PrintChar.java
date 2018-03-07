package ByComs.Facebook;

public class PrintChar {
    private void printChar(char c) {
        System.out.print(c);
    }

    public void printInteger(int x) {
        if (x >= 0 && x <= 9) {
            printChar((char)(x + '0'));
        }
        else{
            printInteger(x/10);
            x %= 10;
            printChar((char) (x + '0'));
        }
    }

    public void printIntegerIter(int x) {
        if (x < 0)
            return;
        if (x >= 0 && x <= 9) {
            printChar((char)(x + '0'));
            return;
        }
        int cnt = 0;
        int xx = x;
        while(xx > 0) {
            cnt++;
            xx /=10;
        }
        while (cnt > 0) {
            cnt --;
            xx = (int) (x / (Math.pow(10,cnt)));
            x %= (int) (Math.pow(10,cnt));
            printChar((char) (xx + '0'));
        }

    }

    public static void main(String[] args) {
        PrintChar test = new PrintChar();
        test.printInteger(123);
//        test.printInteger(100);
//        test.printInteger(0);
//        test.printIntegerIter(123);
//        test.printIntegerIter(100);
//        test.printInteger(0);

//        test.printInteger(12343215);
//        test.printIntegerIter(12343215);

    }
}


/*


    def print_char(self,c):
        print c,

    def print_integer(self, x):
        offset = 48
        if 0 <= x <= 9:
            self.print_char(chr(x + offset))
        else:
            self.print_integer(x/10)
            x %= 10
            self.print_char(chr(x + offset))

 */