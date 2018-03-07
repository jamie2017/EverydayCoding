package IO_FIles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by JMYE on 5/10/17.
 */
public class MyIODemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/JMYE/Google Drive/PureJava/src/IO_FIles/InputFile.txt");
            out = new FileOutputStream("/Users/JMYE/Google Drive/PureJava/src/IO_FIles/OutputFile.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
        finally {
            if(in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
