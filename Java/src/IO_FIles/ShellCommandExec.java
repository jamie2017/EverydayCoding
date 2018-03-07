package IO_FIles;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by JMYE on 5/10/17.
 *
 * https://www.javacodegeeks.com/2015/06/java-programming-tips-best-practices-beginners.html
 */
public class ShellCommandExec {
    public static void main(String[] args) {
        String gnomeOpenCommand = "open /Users/JMYE/Google Drive/PureJava/src/IO_FIles/AnalyticsInfraExercise.pdf";

        try {
            Runtime rt = Runtime.getRuntime();
            Process processObj = rt.exec(gnomeOpenCommand);

            InputStream stdin = processObj.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);

            String myoutput = "";

            while ((myoutput=br.readLine()) != null) {
                myoutput = myoutput+"\n";
            }
            System.out.println(myoutput);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
