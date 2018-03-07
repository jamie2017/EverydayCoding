package String;

/**
 * Created by JMYE on 9/10/16.
 */
public class ReadNCharactersGivenRead4 {
//    public int read(char[] buf, int n) {
//        boolean eof = false;
//        int haveRead = 0;
//        char[] tmp = new char[4];
//
//        while(!eof && haveRead < n) {
//            int count = read4(tmp);
//            eof = count < 4;
//            count = Math.min(count, n - haveRead);
//
//            for (int i = 0; i < count; i++) {
//                buf[haveRead++] = tmp[i];
//            }
//        }
//        return haveRead;
//    }

    // support multipe time read
    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;
//    public int read_mult(char[] buf, int n) {
//        int i = 0;
//        while(i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4)))) {
//            buf[i++] = buf4[i4++];
//        }
//        return i;
//    }


}
