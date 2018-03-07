package ByComs.Google.JavaSerialization;

/**
 * Created by JMYE on 6/26/17.
 * http://javabeginnerstutorial.com/core-java-tutorial/java-serialization-concept-example/
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializaitonClass {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.firstName = "Jamie";
        emp.lastName = "Ye";

        try {
            String fileName = System.getProperty("user.dir") + "/ByCompany/src/Google/JavaSerialization/employee.txt";
            System.out.println(fileName);
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in emploee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
