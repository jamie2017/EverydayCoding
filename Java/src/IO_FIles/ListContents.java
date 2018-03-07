package IO_FIles;

/**
 * Created by JMYE on 5/10/17.
 */
import java.io.*;

public class ListContents {
    public static void main(String[] args) {
        File file = new File("/Users/JMYE/Google Drive/PureJava/src/IO_Files");
        String[] files = file.list();

        System.out.println("Listing contents of " + file.getPath());
        for(int i=0 ; i < files.length ; i++)
        {
            System.out.println(files[i]);
        }
    }
}
